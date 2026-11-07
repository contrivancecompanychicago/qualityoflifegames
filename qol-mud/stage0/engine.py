"""Quality of Life Games MUD — deterministic Stage 0A engine (Python 3)."""
from __future__ import annotations
import json
from copy import deepcopy
from pathlib import Path

ROOM = {
    "id": "MPH-000",
    "zone": 0,
    "name": "Emergency Room Bay",
    "description": (
        "Fluorescent lights illuminate the emergency room. Nurse Carter "
        "stands beside Patient SP-000. Observer Drone K-7 circles near the "
        "ceiling. A locked biometric terminal glows amber on the wall."
    ),
    "npcs": ["Nurse Carter", "Observer Drone K-7"],
    "patients": ["SP-000"],
    "objects": ["Biometric Terminal", "Patient Monitor", "Supply Cabinet"],
    "exits": {"north": "Trauma Center Corridor"},
}
QUEST_COMMANDS = [
    "/scan patient", "/talk carter", "/hack terminal",
    "sync-1561", "/stabilize sp-000", "/report",
]

def initial_state():
    return {
        "schema_version": "qol-mud-stage0",
        "game_id": "krebsville-unequal-treatment-pt1",
        "version": "KNUET-v0.0.0",
        "player": {
            "name": "Dr. Grant", "role": "Analyst",
            "health": 100, "time_tokens": 37, "credits": 3480,
            "xp": 10, "inventory": [],
        },
        "world": {
            "zone": 0, "room": "MPH-000", "hazard_level": 0,
            "stability": 100, "scene_state": 0,
        },
        "quest": {
            "id": "ZONE0_PATIENT_SYNC", "step": 0,
            "completed": False, "zone1_unlocked": False,
        },
        "patient": {"id": "SP-000", "health": 42, "stress": 10, "stabilized": False},
        "evidence": [],
        "event_log": [],
    }

class QOLMud:
    def __init__(self, state=None):
        self.state = deepcopy(state) if state is not None else initial_state()

    def command(self, raw):
        cmd = " ".join(raw.strip().lower().split())
        if cmd in ("/look", "look"):
            return ROOM["description"]
        if cmd in ("/status", "status"):
            p, w, q = self.state["player"], self.state["world"], self.state["quest"]
            return (f"{p['name']} ({p['role']}) | Health {p['health']} | "
                    f"Time {p['time_tokens']} | Credits {p['credits']} | XP {p['xp']} | "
                    f"Hazard {w['hazard_level']}/5 | Stability {w['stability']}% | "
                    f"Quest {q['step']}/6")
        if cmd in ("/help", "help"):
            return "Commands: /look, /status, /help, /scan patient, /talk carter, /hack terminal, SYNC-1561, /stabilize SP-000, /report, /move north"
        if cmd in ("/move north", "move north"):
            return ("Trauma Center Corridor unlocked (Zone 1 adapter pending)."
                    if self.state["quest"]["zone1_unlocked"]
                    else "North exit locked: complete ZONE0_PATIENT_SYNC.")
        q = self.state["quest"]
        if q["completed"]:
            return "Quest complete. Use /status or /look."
        expected = QUEST_COMMANDS[q["step"]]
        if cmd != expected:
            return f"SYSTEMIC OVERSEER: Current objective {q['step'] + 1}/6. Try /help."
        if self.state["player"]["time_tokens"] < 1:
            return "Insufficient Time Tokens."
        self.state["player"]["time_tokens"] -= 1
        q["step"] += 1
        self.state["world"]["scene_state"] = min(q["step"], 5)
        self.state["event_log"].append({"command": cmd, "step": q["step"]})
        responses = [
            "Patient SP-000 scanned. Monitor desynchronization detected.",
            "Nurse Carter: The patient monitor is desynchronized.",
            "Biometric terminal handshake initiated.",
            "SYNC-1561 accepted. Biometric terminal synchronized.",
            "Patient SP-000 stabilized.",
            "Report submitted. Zone 1 access unlocked.",
        ]
        if q["step"] == 5:
            self.state["patient"]["stabilized"] = True
        if q["step"] == 6:
            q["completed"] = True
            q["zone1_unlocked"] = True
            self.state["player"]["xp"] += 15
            self.state["player"]["credits"] += 100
            self.state["world"]["stability"] = min(100, self.state["world"]["stability"] + 3)
            self.state["evidence"].append("TRIAGE_PRIORITY_LOG_001")
        return responses[q["step"] - 1]

    def save(self, path):
        path = Path(path)
        path.parent.mkdir(parents=True, exist_ok=True)
        path.write_text(json.dumps(self.state, indent=2), encoding="utf-8")
        return path

    @classmethod
    def load(cls, path):
        data = json.loads(Path(path).read_text(encoding="utf-8"))
        if data.get("schema_version") != "qol-mud-stage0":
            raise ValueError("Unsupported save schema")
        if data.get("game_id") != "krebsville-unequal-treatment-pt1":
            raise ValueError("Unsupported game")
        return cls(data)
