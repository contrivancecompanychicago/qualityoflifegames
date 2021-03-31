# qualityoflifegames
Quality of Life Games Series is the Prequel to Public Nuisance City Game
/\* \* DB Script Tool \* PostgreSQL (PLPGSQL) - 2021-03-27 00:42:06 \*
2021-03-01 13:42:34 \* \* SQL COMMANDS FOR Quality\_of\_Life\_Game
DATABASE \*/

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Player \*/ SELECT id, redrace, yellowrace,
purplerace, greenrace, orangerace, bluerace, susceptibleindividual,
exposedindividual, infectedindividual, removedindividual,
intoxicateddriver, shearstress FROM Player WHERE id=? ORDER BY id ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.Player \*/ INSERT INTO
Player(redrace, yellowrace, purplerace, greenrace, orangerace, bluerace,
susceptibleindividual, exposedindividual, infectedindividual,
removedindividual, intoxicateddriver, shearstress) VALUES(0, 0, 0, 0, 0,
0, 0, 0, 0, 0, 0, 0.0);

/\* \* Update command - Quality\_of\_Life\_Game.Player \*/ UPDATE Player
SET redrace=0, yellowrace=0, purplerace=0, greenrace=0, orangerace=0,
bluerace=0, susceptibleindividual=0, exposedindividual=0,
infectedindividual=0, removedindividual=0, intoxicateddriver=0,
shearstress=0.0 WHERE id=?;

/* * Delete command - Quality\_of\_Life\_Game.Player \*/ DELETE FROM
Player WHERE id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Nonplayer \*/ SELECT *id, rexoedipus,
lightbluerace, pinkrace, brownrace, fred, edtdoide, genecrispy,
hysteriaptrance, officermodusponens, officermodustollens, sifidious,
imhotepbizarros, barryukolmar, ableacage FROM Nonplayer WHERE *id=?
ORDER BY \_id ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.Nonplayer \*/ INSERT
INTO Nonplayer(rexoedipus, lightbluerace, pinkrace, brownrace, fred,
edtdoide, genecrispy, hysteriaptrance, officermodusponens,
officermodustollens, sifidious, imhotepbizarros, barryukolmar,
ableacage) VALUES(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

/\* \* Update command - Quality\_of\_Life\_Game.Nonplayer \*/ UPDATE
Nonplayer SET rexoedipus=0, lightbluerace=0, pinkrace=0, brownrace=0,
fred=0, edtdoide=0, genecrispy=0, hysteriaptrance=0,
officermodusponens=0, officermodustollens=0, sifidious=0,
imhotepbizarros=0, barryukolmar=0, ableacage=0 WHERE \_id=?;

/* * Delete command - Quality\_of\_Life\_Game.Nonplayer \*/ DELETE FROM
Nonplayer WHERE \_id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Neighborhoods \*/ SELECT *id, redneighborhood,
yellowneighborhood, purpleneigborhood, greenneighborhood,
orangeneighborhood, blueneighborhood FROM Neighborhoods WHERE *id=?
ORDER BY \_id ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.Neighborhoods \*/ INSERT
INTO Neighborhoods(redneighborhood, yellowneighborhood,
purpleneigborhood, greenneighborhood, orangeneighborhood,
blueneighborhood) VALUES(0, 0, 0, 0, 0, 0);

/\* \* Update command - Quality\_of\_Life\_Game.Neighborhoods \*/ UPDATE
Neighborhoods SET redneighborhood=0, yellowneighborhood=0,
purpleneigborhood=0, greenneighborhood=0, orangeneighborhood=0,
blueneighborhood=0 WHERE \_id=?;

/* * Delete command - Quality\_of\_Life\_Game.Neighborhoods \*/ DELETE
FROM Neighborhoods WHERE \_id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Social\_Bubbles \*/ SELECT *id,
socioeconomicstatus, household, race, transportation,
epidemiologicalfactors, healthfactors, needs, lifeshocks,
viciouscyclesofpoverty, lossofincome, dropinincome FROM Social*Bubbles
WHERE *id=? ORDER BY *id ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.Social\_Bubbles \*/
INSERT INTO Social\_Bubbles(socioeconomicstatus, household, race,
transportation, epidemiologicalfactors, healthfactors, needs,
lifeshocks, viciouscyclesofpoverty, lossofincome, dropinincome)
VALUES(0.0, 1, 1, '2021-03-27 00:42:06', 0.0, 1, 1, 0, 0, 0.0, 0.0);

/\* \* Update command - Quality\_of\_Life\_Game.Social\_Bubbles \*/
UPDATE Social\_Bubbles SET socioeconomicstatus=0.0, household=1, race=1,
transportation='2021-03-27 00:42:06', epidemiologicalfactors=0.0,
healthfactors=1, needs=1, lifeshocks=0, viciouscyclesofpoverty=0,
lossofincome=0.0, dropinincome=0.0 WHERE \_id=?;

/* * Delete command - Quality\_of\_Life\_Game.Social\_Bubbles \*/ DELETE
FROM Social\_Bubbles WHERE \_id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Health\_Factors \*/ SELECT *id,
unexpectedpregnancy, measles, mumps, rubella, pneumonia, diabetes FROM
Health*Factors WHERE *id=? ORDER BY *id ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.Health\_Factors \*/
INSERT INTO Health\_Factors(unexpectedpregnancy, measles, mumps,
rubella, pneumonia, diabetes) VALUES(0, 0, 0, 0, 0, 0);

/\* \* Update command - Quality\_of\_Life\_Game.Health\_Factors \*/
UPDATE Health\_Factors SET unexpectedpregnancy=0, measles=0, mumps=0,
rubella=0, pneumonia=0, diabetes=0 WHERE \_id=?;

/* * Delete command - Quality\_of\_Life\_Game.Health\_Factors \*/ DELETE
FROM Health\_Factors WHERE \_id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Socioeconomic\_Status \*/ SELECT *id,
bankruptcy, unemployment, homeinvasion, incomedrop, incomeloss, eviction
FROM Socioeconomic*Status WHERE *id=? ORDER BY *id ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.Socioeconomic\_Status
\*/ INSERT INTO Socioeconomic\_Status(bankruptcy, unemployment,
homeinvasion, incomedrop, incomeloss, eviction) VALUES(0, 0, 0, 0, 0,
0);

/\* \* Update command - Quality\_of\_Life\_Game.Socioeconomic\_Status
\*/ UPDATE Socioeconomic\_Status SET bankruptcy=0, unemployment=0,
homeinvasion=0, incomedrop=0, incomeloss=0, eviction=0 WHERE \_id=?;

/* * Delete command - Quality\_of\_Life\_Game.Socioeconomic\_Status \*/
DELETE FROM Socioeconomic\_Status WHERE \_id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Random\_Glucose\_Levels \*/ SELECT *id,
kentuckyfriedchicken, ramenfury, diabetesindividuals, pizza FROM
Random*Glucose\_Levels WHERE *id=? ORDER BY *id ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.Random\_Glucose\_Levels
\*/ INSERT INTO Random\_Glucose\_Levels(kentuckyfriedchicken, ramenfury,
diabetesindividuals, pizza) VALUES(0, 0, 0, 0);

/\* \* Update command - Quality\_of\_Life\_Game.Random\_Glucose\_Levels
\*/ UPDATE Random\_Glucose\_Levels SET kentuckyfriedchicken=0,
ramenfury=0, diabetesindividuals=0, pizza=0 WHERE \_id=?;

/* * Delete command - Quality\_of\_Life\_Game.Random\_Glucose\_Levels
\*/ DELETE FROM Random\_Glucose\_Levels WHERE \_id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.COSINE\_MUD\_Box \*/ SELECT *id,
cosinegameforum, publicnuisancecitygame, qualityoflifegames,
socialbubbles, deviceType FROM COSINE*MUD\_Box WHERE *id=? ORDER BY *id
ASC;

/\* \* Insert command - Quality\_of\_Life\_Game.COSINE\_MUD\_Box \*/
INSERT INTO COSINE\_MUD\_Box(cosinegameforum, publicnuisancecitygame,
qualityoflifegames, socialbubbles, deviceType) VALUES(0, 0, 0, 0, 0.0);

/\* \* Update command - Quality\_of\_Life\_Game.COSINE\_MUD\_Box \*/
UPDATE COSINE\_MUD\_Box SET cosinegameforum=0, publicnuisancecitygame=0,
qualityoflifegames=0, socialbubbles=0, deviceType=0.0 WHERE \_id=?;

/* * Delete command - Quality\_of\_Life\_Game.COSINE\_MUD\_Box \*/
DELETE FROM COSINE\_MUD\_Box WHERE \_id=?;

/\* ----------------------------------- \* Select command -
Quality\_of\_Life\_Game.Pentose\_Phosphate\_Freeway \*/ SELECT *id,
phagehexamernanocar2020, keggcolorpathway, intensity FROM
Pentose*Phosphate\_Freeway WHERE *id=? ORDER BY *id ASC;

/\* \* Insert command -
Quality\_of\_Life\_Game.Pentose\_Phosphate\_Freeway \*/ INSERT INTO
Pentose\_Phosphate\_Freeway(phagehexamernanocar2020, keggcolorpathway,
intensity) VALUES(0, 1, 0);

/\* \* Update command -
Quality\_of\_Life\_Game.Pentose\_Phosphate\_Freeway \*/ UPDATE
Pentose\_Phosphate\_Freeway SET phagehexamernanocar2020=0,
keggcolorpathway=1, intensity=0 WHERE \_id=?;

/* * Delete command -
Quality\_of\_Life\_Game.Pentose\_Phosphate\_Freeway \*/ DELETE FROM
Pentose\_Phosphate\_Freeway WHERE \_id=?;
