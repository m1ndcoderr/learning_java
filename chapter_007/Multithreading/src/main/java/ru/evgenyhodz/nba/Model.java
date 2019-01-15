package ru.evgenyhodz.nba;

/**
 * @author Evgeny Khodzitskiy (evgeny.hodz@gmail.com)
 * @since 28.03.2017
 */
public class Model {

    private int var;
    private String data;
    private volatile int version = 0;

    public Model(int var, String data) {
        this.var = var;
        this.data = data;
    }

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getVersion() {
        return version;
    }

    public void increaseVersion(){
        this.version++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (var != model.var) return false;
        if (version != model.version) return false;
        return data != null ? data.equals(model.data) : model.data == null;

    }

    @Override
    public int hashCode() {
        int result = var;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + version;
        return result;
    }
}
