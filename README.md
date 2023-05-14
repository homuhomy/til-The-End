# til-The-End

A. Introduction
You are the mayor of Kuala Lumpur and you are responsible to protect the city from any invasion. One day, a
newly-born dragon performed a sudden surprise attack on your city!
Luckily, your wall successfully defended the dragon’s attack and the dragon retreated after getting damaged by
your tower. You are aware that it might return to your city again. You have to stop the dragon from destroying your
city. Therefore, you have to strengthen your city’s defence by upgrading your tower and wall to fight the dragon!

B. Problem Statement & Sample Input Output
You are required to build a brand new Tower of Defence game that allows you - the mayor of the city – to keep
your city safe and defeat the dragon.

Basic Requirements:

  1. Year & Season:
    There are 4 seasons in a year: Spring, Summer, Autumn and Winter.
    Each season, there will be a random event occurring.
    At each start of the season, you will have to arrange your strategy for your tower, wall and citizens.
    You are starting the game with Year 1. After 4 seasons, you will proceed with Year 2 and the list goes on.

  2. Command Panel
    At each start of the season, you will have to arrange your strategy for your tower, wall and citizens.
    The command panel allows you to select towers, walls and citizens to upgrade their stats. After you have spent your
    gold, you can enter the command to proceed to face the dragon.

  3. Tax:
    You will have 200 gold initially when you start the game.
    At each start of the season, you will tax your citizens as your income. The tax collected is randomised. You will
    collect 200/250/300/350/400 gold each season.
    You can use your income to upgrade your tower, upgrade your wall or confront your citizens’ emotions (increase
    or decrease emotion points).

  4. Dragon:
    Dragon is newly born and starts with level 1.

      Dragon initial stats:
      Level = 1
      HealthPoint = 100
      AttackPoint = 7
      Critical Chance Percentage (Increase dragon’s attack damage by 50%) = 20%
      Accuracy Percentage= 80%
  
  Dragon will flee from your city after attacking your wall 10 times.
  It recovers fully and will level up each season.

  Dragon levels up:
      HealthPoint + 15
      AttackPoint +1
      Critical Chance Percentage +2% (Note: Level 2 dragon has 22% Critical Chance Percentage, Level 3 dragon has
      24% Critical Chance Percentage, Level 4 dragon has 26% Critical Chance Percentage...etc)
  
  It will return to your city every season until you kill it!

  5. Tower:
    Tower attacks the dragon. It aims to kill the dragon.

  Tower initial stats:
      AttackPoint = 5
      Critical Chance Percentage (Increase tower’s attack damage by 50%) = 10%
      Accuracy Percentage = 80%
      
  Use your gold to upgrade your tower stats!
      100 Gold – AttackPoint +1
      100 Gold – Critical Chance Percentage +5% (First upgrade will increase the tower’s Critical Chance Percentage to
      15%, the second upgrade will increase the tower’s Critical Chance Percentage to 20%...etc)
      100 Gold – Accuracy Percentage +4% (The first upgrade will increase the tower’s Accuracy Percentage to 84%,
      the second upgrade will increase the tower’s Accuracy Percentage to 88%...etc)
      
      
  6. Wall:
    Wall protects the city against dragons.
 
  Wall initial stats:
    HealthPoint = 100
    Block Percentage (Reduce damage received by the dragon to 0) = 10%
  
  The HealthPoint of your wall won’t reset each season. You have to use your gold to increase your wall’s
  HealthPoint!
    100 Gold – HealthPoint +75
    100 Gold – Block Percentage +5% (First upgrade will increase the wall’s Block Percentage to 15%, the second
    upgrade will increase the wall’s Block Percentage to 20%...etc)


  7. Citizens:
    Citizens are the root of your city. Citizens are also human, so of course they will have their own emotions. They
    have the list of emotions below:
      ● Emotional
      ● Nervous
      ● Lazy
      ● Berserk
      ● Diligent
      ● Fearless
  
  The initial emotions:
      ● Emotional = 10 (CAPPED at 100)
      ● Nervous = 10 (CAPPED at 100)
      ● Lazy = 10 (CAPPED at 100)
      ● Berserk = 10 (CAPPED at 100)
      ● Diligent = 10 (CAPPED at 100)
      ● Fearless = 10 (CAPPED at 100)
      
  If the following emotion reaches 100 or above, the emotion will be triggered. Below are effects that will take place
  when each emotion is triggered:
      ● Emotional = Decrease Tower’s AttackPoint by 1 PERMANENTLY
      ● Nervous = Decrease Tower Accuracy Percentage by 5% PERMANENTLY
      ● Lazy = Decrease Wall’s HealthPoint by 100 PERMANENTLY
      ● Berserk = Increase Tower’s AttackPoint by 1 PERMANENTLY
      ● Diligent = Increase Wall’s HealthPoint by 75 PERMANENTLY
      ● Fearless = Increase Tower Critical Chance Percentage by 5% PERMANENTLY

If emotion is triggered after the effect takes place, minus the emotion point by 100.
For example, if your citizens have 110 Lazy Point, your wall’s HealthPoint will decrease by 50 PERMANENTLY.
After that, your Lazy Point will become 10.
If your citizens have 120 Fearless Point, your tower’s Critical Chance Percentage will increase by 5%
PERMANENTLY. If you have an 80% Critical Chance Percentage, it will be increased to 85%. After that, your
Fearless Point will become 20.

You can use gold to confront your citizens! You can either decrease or increase the emotion points!
  50 Gold – Decrease 50 Emotional Point
  50 Gold – Decrease 50 Nervous Point
  50 Gold – Decrease 50 Lazy Point
  50 Gold – Decrease 50 Berserk Point
  50 Gold – Decrease 50 Diligent Point
  50 Gold – Decrease 50 Fearless Point
  
  8. Events:
    There are a lot of random events that could happen during each season.
  
  Spring:
    ● Reinforcement (Increase Tower’s AttackPoint by 1 PERMANENTLY)
    ● Visitors (Get 100 gold)
    ● Festival (Increase Berserk, Diligent and Fearless Point by 50 PERMANENTLY)
 
 Summer:
    ● Drought (Decrease Wall’s HealthPoint by 50 PERMANENTLY)
    ● Outing (Increase Berserk, Diligent and Fearless Point by 50 PERMANENTLY)
    ● Heatstroke (Increase Emotional, Nervous, Lazy Point by 50 PERMANENTLY)
  
  Autumn:
    ● Rainy (Minus Tower Accuracy Percentage by 20% DURING THE SEASON)
    ● Flood (Decrease Wall’s HealthPoint by 50 PERMANENTLY)
    ● Harvest (Get 100 gold)
 
 Winter:
    ● Blizzard (Decrease Wall’s HealthPoint by 50 PERMANENTLY)
    ● Avalanche (Increase Emotional, Nervous, Lazy Point by 50 PERMANENTLY)
    ● Hunger (Minus Tower Accuracy Percentage by 20% DURING THE SEASON)
    ● Tour group (Get 100 gold)

  9. OOP concept
    Create a Java abstract class named “SameBehaviour” with relevant data fields and abstract
    methods declared. The relevant data fields and abstract methods are related to stats
    mentioned in Dragon and Tower. This abstract class must be extended by Dragon and Tower.
    
  10. Start of The Game
    A Level 1 dragon performs a sudden attack on your city!
    Dragon will attack your wall first. And then your tower will respond by attacking the dragon.
    After attacking 10 times, the dragon will flee.

    The game will begin from Year 1, Spring with your retaining wall’s health. The event will happen and tax
    will be collected. You can perform actions such as upgrade your tower and wall using your gold.
    When you have spent your gold and proceed, the dragon will return as a Level 2 dragon and perform another
    10 attacks again before it flees.

    The game now enters Year 1, Summer with your retaining wall’s health... the loop goes on until they win
    or loses condition is satisfied!
    
  11. Win Condition:
    You kill the dragon! The health of the dragon reduces to 0.
    
  12. Lose Condition:
    The dragon breaks your wall! The health of your wall reduces to 0.
    
C. Extra Features:

  1. Graphical User Interface (GUI)
    Make the game more attractive to end-users by implementing GUI.

  2. Animation/sound effects
    Try to put some animations or sound effects in your game. (Example: Dragon’s attack will produce a
    RRRRRRR sound effect)

  3. Diversity
    Implement more different events each season to diverse the game. You can also code your program to let
    two events happen each season.

  4. Hard mode
    Let the user select the difficulty of the game.
    Example: To increase the difficulty of the game, you can
      - Decrease the tax received each season
      - Increase dragon’s stats
      - More negative events each season, etc

  5. Save and Load System
    Players can save the game and resume it later. Uses Java IO knowledge you have learnt in
    lectures to accomplish this feature. File encryption is another extra point, you can
    implement it to protect your saved files.

  6. Any other extra features that can impress us or make the game more interesting!
