Pour compiler et exécuter le projet :

    - Il faut se déplacer dans le dossier src "cd ./src"
    - Compiler l'ensemble du project dans un dossier build "javac -Xlint:deprecation -d ./build *.java"
    - Se déplacer dans le dossier Build "cd ./build"
    - Executer la class Main "java Main"


    /** Sans les commentaires **/
    - cd ./src
    - javac -Xlint:deprecation -d ./build *.java
    - cd ./build
    - java Main

    Description des classes à partir de src
    Main.java | Classe de lancement de l'application

    - Launcher | Launcher de le l'application, la jframe du menu et du jeu
        Balorant.java | Classe de gestion de la Jframe

    - Controller
        - MainMenu | Les contrôleurs du menu
            ChoiceMenuController | Les buttons pour le choix du mode de jeu (Code Rouge, Mission Radar...)
            NombreDeJoueurController | Sélection du nombre de joueur humain (IA vs IA, IA vs Humain, Humain vs Humain)

        - Partie
            NextTurnController | Contrôleur pour le button du tour suivant

            - Plateau
                PlacementBateauController | Les radio buttons pour le placement du bateau (Horizontal, Vertical)

                - Case
                    CasePlacementBateauController | Contrôleur pour une case lors du placement des bateaux
                    CaseController | Contrôleur pour une case lors de la partie



    - Models | Les models de l'application
        Constants | Les contantes utillisées par l'application

        - Array | Limitation de l'arrayList
            LimitedArrayList | L'arrayList limitée
            ListTooLargeException | L'erreur retournée

        - Case
            - Case | Une case de la grille
            - CaseBateau | Une case de la grille contenant un bateau

        - Joueur | Les types de joueurs de l'application
            Joueur
            Humain
            Ordinateur

        - Mode | Les modes de l'application
            AlerteRouge
            BatailleNavale
            ...

        - Navire | Les navires utilisées
            Cuirasse
            PorteAvion
            ...

    - View | Les View de l'application
        - MainMenu
            MainMenuView | Vue du menu principal
            OptionPartie | Jpanel contenant les options de la partie (IA, Joueur, Mode de jeu)

        - Partie
            PartieTermineeView | Vue quand la partie est terminée, Affichage du vainqueur
            PartieView | Vue de la partie

            - PlateauView
                LegendeView | Vue affichant la légende des cases
                OperationArtillerieView | Vue de l'opération artillerie (Sélection des coordonnées)
                PlateauView | Vue d'un plateau
                PlateauxView | Vue des deux plateaux

                - CaseView
                    CasePlacementBateau | Vue représentant une case lors du placement des bateaux
                    CaseView | Vue représentant une case en partie

                - PlacementBateau
                    LegendePlacementBateau | Légende lors du placement des bateaux
                    PlacementBateauView | Vue pour placer les bateaux

                - Transition
                    AttentePlacementBateauOrdinateur | Ecran d'attente lorsque que l'ordinateur place ses bateaux
                    AttenteTirOrdinateur | Ecran d'attente lorsque que l'ordinateur est en train de tirer
                    SwitchView | Vue de switch quand deux joueurs humain s'affrontent
