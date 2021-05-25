package splitString;


class Person {
    public int id;
    public String name;
    public double score;

    public Person() {
    }

    public Person(int id, String name, double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return name+"   "+score;
    }
}
