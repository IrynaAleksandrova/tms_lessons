package org.example.builder;

public class Person {

    private String name;
    private int age;
    private int born;
    private Category category;
    private String type;

    public Person(String name, int age, int born, Category category, String type) {
        this.name = name;
        this.age = age;
        this.born = born;
        this.category = category;
        this.type = type;
    }

    public Person() {
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getBorn() {
        return this.born;
    }

    public Category getCategory() {
        return this.category;
    }

    public String getType() {
        return this.type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBorn(int born) {
        this.born = born;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Person)) return false;
        final Person other = (Person) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        if (this.getAge() != other.getAge()) return false;
        if (this.getBorn() != other.getBorn()) return false;
        final Object this$category = this.getCategory();
        final Object other$category = other.getCategory();
        if (this$category == null ? other$category != null : !this$category.equals(other$category)) return false;
        final Object this$type = this.getType();
        final Object other$type = other.getType();
        if (this$type == null ? other$type != null : !this$type.equals(other$type)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Person;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        result = result * PRIME + this.getAge();
        result = result * PRIME + this.getBorn();
        final Object $category = this.getCategory();
        result = result * PRIME + ($category == null ? 43 : $category.hashCode());
        final Object $type = this.getType();
        result = result * PRIME + ($type == null ? 43 : $type.hashCode());
        return result;
    }

    public String toString() {
        return "Person(name=" + this.getName() + ", age=" + this.getAge() + ", born=" + this.getBorn() + ", category=" + this.getCategory() + ", type=" + this.getType() + ")";
    }

    public static class PersonBuilder {
        private String name;
        private int age;
        private int born;
        private Category category;
        private String type;

        PersonBuilder() {
        }

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public PersonBuilder born(int born) {
            this.born = born;
            return this;
        }

        public PersonBuilder category(Category category) {
            this.category = category;
            return this;
        }

        public PersonBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Person build() {
            return new Person(name, age, born, category, type);
        }

        public String toString() {
            return "Person.PersonBuilder(name=" + this.name + ", age=" + this.age + ", born=" + this.born + ", category=" + this.category + ", type=" + this.type + ")";
        }
    }
}
