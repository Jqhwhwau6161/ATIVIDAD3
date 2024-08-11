import java.util.Scanner;

 class AngryBirds {

    // Clase base Pajaro
     static class Pajaro {
        private String nombre;
        private int energia;

         Pajaro(String nombre, int energia) {
            this.nombre = nombre;
            this.energia = energia;
        }

         String getNombre() {
            return nombre;
        }

         int getEnergia() {
            return energia;
        }

        public void atacar() {
            if (energia > 0) {
                System.out.println(nombre + " está atacando con energía: " + energia);
                energia -= 10; // Reduce la energía en 10 después del ataque
                if (energia <= 0) {
                    energia = 0;
                    System.out.println(nombre + " está muerto.");
                }
            } else {
                System.out.println(nombre + " ya está muerto y no puede atacar.");
            }
        }

        public void imprimir() {
            System.out.println("Nombre: " + nombre);
            System.out.println("Energía: " + energia);
        }
    }

    // Subclase PajaroRojo
    public static class PajaroRojo extends Pajaro {

        public PajaroRojo() {
            super("Pájaro Rojo", 100);
        }

        @Override
        public void atacar() {
            System.out.println(getNombre() + " lanza un ataque de fuego con energía: " + getEnergia());
            super.atacar(); // Llama al método atacar de la superclase
        }
    }

    // Subclase PajaroAzul
    public static class PajaroAzul extends Pajaro {

        public PajaroAzul() {
            super("Pájaro Azul", 100);
        }

        @Override
        public void atacar() {
            System.out.println(getNombre() + " realiza un ataque de triple impacto con energía: " + getEnergia());
            super.atacar(); // Llama al método atacar de la superclase
        }
    }

    // Subclase PajaroVerde
    public static class PajaroVerde extends Pajaro {

        public PajaroVerde() {
            super("Pájaro Verde", 100);
        }

        @Override
        public void atacar() {
            System.out.println(getNombre() + " hace un ataque explosivo con energía: " + getEnergia());
            super.atacar(); // Llama al método atacar de la superclase
        }
    }

    // Clase Main para probar las clases
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear instancias de diferentes tipos de pájaros
        Pajaro[] pajaros = new Pajaro[3];
        pajaros[0] = new PajaroRojo();
        pajaros[1] = new PajaroAzul();
        pajaros[2] = new PajaroVerde();

        System.out.println("Ingrese comandos para atacar a los pájaros:");
        System.out.println("Ejemplo de comandos: 'angry rojo', 'angry azul', 'angry verde'");

        while (true) {
            System.out.print("Comando: ");
            String comando = scanner.nextLine().toLowerCase();
            if (comando.equals("salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            // Procesar el comando
            if (comando.startsWith("angry")) {
                String[] partes = comando.split(" ");
                if (partes.length == 2) {
                    String color = partes[1];
                    switch (color) {
                        case "rojo":
                            if (pajaros[0] != null) {
                                pajaros[0].atacar();
                                pajaros[0].imprimir();
                            } else {
                                System.out.println("Pájaro Rojo no existe.");
                            }
                            break;
                        case "azul":
                            if (pajaros[1] != null) {
                                pajaros[1].atacar();
                                pajaros[1].imprimir();
                            } else {
                                System.out.println("Pájaro Azul no existe.");
                            }
                            break;
                        case "verde":
                            if (pajaros[2] != null) {
                                pajaros[2].atacar();
                                pajaros[2].imprimir();
                            } else {
                                System.out.println("Pájaro Verde no existe.");
                            }
                            break;
                        default:
                            System.out.println("Comando no válido. Use 'angry rojo', 'angry azul', o 'angry verde'.");
                    }
                } else {
                    System.out.println("Comando no válido. Use 'angry rojo', 'angry azul', o 'angry verde'.");
                }
            } else {
                System.out.println("Comando no reconocido. Use 'angry' seguido del color del pájaro.");
            }
        }
        scanner.close();
    }
}
