    package hm5.animal;

    public class Cat extends Animal {
        private static int catCount = 0;
        public Cat(String name) {
            this.name = name;
            catCount++;
        }

        public void setName(String name) {
            this.name = name;

        }

        public static int getCatCount() {
            return catCount;
        }

        @Override
        public void run(int distance) {
            if (distance > 200) {
                System.out.println("Кіт " + getName() + " не бігає більше 200 м");
            } else if (distance < 0) {
                System.out.println("Відстань не може бути негативна");
            } else System.out.println("Кіт" + getName() + "  пробіг:" + distance + " m");
        }

        @Override
        public void swim(int distance) {
            if(distance < 0) {
                System.out.println("Відстань не може бути негативна");
            }else if (distance >= 0 ) {
            System.out.println("Кіт не вміє плавати");
            }
        }
    }
