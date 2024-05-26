import java.util.Objects;
public class NB {

    private String name;
    private int ramInGB;
    private int valueHDD;
    private String operatingSystem;
    private String color;

    public NB(String name, int ramInGB, int valueHDD, String operatingSystem, String color) {
        this.name = name;
        this.ramInGB = ramInGB;
        this.valueHDD = valueHDD;
        this.operatingSystem = operatingSystem;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRamInGB() {
        return ramInGB;
    }

    public void setRamInGB(int ramInGB) {
        this.ramInGB = ramInGB;
    }

    public int getValueHDD() {
        return valueHDD;
    }

    public void setValueHDD(int valueHDD) {
        this.valueHDD = valueHDD;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "NB{" +
                "Наименование: '" + name + '\'' +
                ", оперативная память: " + ramInGB +
                ", объём жесткого диска: " + valueHDD +
                ", ос: " + operatingSystem +
                ", цвет корпуса: '" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NB note = (NB) obj;
        return name.equals(note.name) && ramInGB == note.ramInGB && valueHDD == note.valueHDD
                && operatingSystem.equals(note.operatingSystem) && color.equals(note.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ramInGB, valueHDD, operatingSystem, color);
    }
}