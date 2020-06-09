package ar.com.jekipes.enums;

/**
 *
 * @author juan kipes
 */
public enum HandSign {
    ROCK {
        @Override
        public void show() {
            System.out.println("Mi turno: Piedra");
        }

        @Override
        public String toString() {
            return "Piedra";
        }

    },
    PAPER {
        @Override
        public void show() {
            System.out.println("Mi turno: Papel");
        }

        @Override
        public String toString() {
            return "Papel";
        }

    },
    SCISSORS {
        @Override
        public void show() {
            System.out.println("Mi turno: Tijera");
        }

        @Override
        public String toString() {
            return "Tijera";
        }

    };

    public abstract void show();

}
