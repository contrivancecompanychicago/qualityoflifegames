# Quality of Life Games — MUD unification analysis

## What was inspected

The root repository tree contains approximately 122 entries and mixes Java, C#, XML, YAML, JSON, Python and Unreal/Unity artifacts. A separate Krebsville Nights Part 1 repository contains browser JS, a Python controller, FastAPI scaffolding, zone JSON and a version 0 rulebook. The ten `server-cloud/` entries are **git submodules**, not source code included in the root tree; their internals were **not** audited in this stage.

## Findings

1. The root README describes a *series* of games, not a shared playable MUD engine.
2. `Character.java`, `CharacterPlayState.java`, and `CharacterHealth.java` contain overlapping character definitions and incompatible constructors. `KrebsvilleWorld.java` has invalid Java declarations; `Game.java` mixes interface and class constructs. They should remain legacy source, not be treated as a working unified engine.
3. `Public_Goods_Game.java` offers a turn/decision/credits model suitable for a later MUD adapter, but it relies on absent or external Java types.
4. `videoGameBase.yaml` is a catalog metadata schema, not a runtime world schema.
5. `server-cloud/COSINE-Game-Server` and other game submodules are integration candidates; their runtime interfaces require separate inspection.
6. The old Krebsville Python controller has multiple conflicting player-state resets and an `eval()` save loader. Never import it wholesale into a shared execution environment.
7. The Krebsville browser game and rulebook establish Zone 0, Dr. Grant, Nurse Carter, SP-000, Drone K-7, time tokens, hazard, system stability, and a six-step quest. Stage 0A implements those in a deterministic Python adapter.

## Proposed unified contract

- **Catalog:** stable `game_id`, display name, adapter status, source link
- **State:** schema_version, game_id, player, world, quest, event_log
- **Commands:** `/look`, `/status`, `/help`, game-specific action commands
- **Action results:** human-readable narrative plus state transition and event log
- **Persistence:** JSON only, versioned and validated before load
- **Adapters:** separate game modules rather than combining incompatible codebases
- **Interfaces:** Colab first; REST/Replit/Unity clients later, all consuming the same state contract

## Stage 0A scope and limitations

- Krebsville Zone 0 is the **only implemented adapter**.
- Quest outcomes are deterministic; D20 checks, autonomous NPC ticks, multiplayer, 30-FPS rendering, and clinical simulation are future stages.
- The current six action commands each consume one token as a Stage 0A rule; exact costs should be reconciled against the canonical rulebook before Stage 0B.
- No patient data, Firebase keys, or credentials are needed.

## Migration stages

- Stage 0A: catalog, Python state, room, commands, ordered quest, tests
- Stage 0B: reconcile rulebook/JS engine and build richer NPC/quest state machines
- Stage 0C: adapt another game (Montrose Point Hospital or Let's Make a Meal)
- Stage 1: expose stable REST endpoints and connect Replit/Unity frontends
