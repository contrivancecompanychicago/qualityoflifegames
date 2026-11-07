import tempfile
import unittest
from pathlib import Path
import sys

sys.path.insert(0, str(Path(__file__).resolve().parents[1]))
from engine import QOLMud, ROOM, QUEST_COMMANDS

class Stage0ATests(unittest.TestCase):
    def test_initial_state(self):
        game = QOLMud()
        self.assertEqual(game.state["player"]["time_tokens"], 37)
        self.assertEqual(game.state["player"]["credits"], 3480)
        self.assertEqual(game.state["player"]["health"], 100)
        self.assertEqual(game.state["world"]["hazard_level"], 0)
        self.assertEqual(game.state["world"]["stability"], 100)
        self.assertEqual(game.state["world"]["room"], "MPH-000")

    def test_room_and_commands(self):
        game = QOLMud()
        self.assertIn("Nurse Carter", game.command("/look"))
        self.assertIn("Time 37", game.command("/status"))
        self.assertIn("/scan patient", game.command("/help"))
        self.assertEqual(ROOM["zone"], 0)

    def test_quest_sequence_and_rewards(self):
        game = QOLMud()
        self.assertIn("locked", game.command("/move north"))
        self.assertEqual(game.command("/report"), "SYSTEMIC OVERSEER: Current objective 1/6. Try /help.")
        for command in QUEST_COMMANDS:
            game.command(command)
        self.assertTrue(game.state["quest"]["completed"])
        self.assertTrue(game.state["patient"]["stabilized"])
        self.assertEqual(game.state["player"]["time_tokens"], 31)
        self.assertEqual(game.state["player"]["credits"], 3580)
        self.assertEqual(game.state["player"]["xp"], 25)
        self.assertIn("TRIAGE_PRIORITY_LOG_001", game.state["evidence"])
        self.assertIn("unlocked", game.command("/move north"))

    def test_safe_json_persistence(self):
        game = QOLMud()
        game.command("/scan patient")
        with tempfile.TemporaryDirectory() as tmp:
            path = game.save(Path(tmp) / "save.json")
            restored = QOLMud.load(path)
            self.assertEqual(restored.state, game.state)

if __name__ == "__main__":
    unittest.main()
