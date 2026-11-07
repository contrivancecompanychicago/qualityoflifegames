# Quality of Life Games MUD — Stage 0

This is an additive, Python-first integration layer for the existing Quality of Life Games portfolio. It does **not** replace the historical Java, C#, Unity, XML, or linked game repositories.

## Run in Google Colab

1. Open a Python 3 Colab notebook.
2. Run:
   ```python
   !git clone --branch qualityoflifegames-mud-stage0 https://github.com/contrivancecompanychicago/qualityoflifegames.git
   %cd qualityoflifegames/qol-mud/stage0
   !python -m unittest discover -s tests -v
   ```
3. Start the MUD:
   ```python
   from engine import QOLMud
   game = QOLMud()
   print(game.command("/look"))
   print(game.command("/status"))
   ```

## Architecture

- `engine.py`: deterministic, portable game state and command dispatcher
- `games.json`: unified catalog and game-specific starting scenarios
- `tests/test_stage0a.py`: Stage 0A acceptance tests
- `ANALYSIS.md`: inventory assessment, compatibility boundaries, migration plan

### Scope

The first playable adapter is Krebsville Nights: Unequal Treatment Part 1, Zone 0 / MPH-000. Other games are cataloged as **planned adapters**, not falsely represented as playable. A common command contract and save schema will let them join later.

Source game: https://github.com/contrivancecompanychicago/krebsville_unequal_treatment_pt1

No external dependencies required for Stage 0A. Do not store API keys, tokens, or patient information in public game saves.
