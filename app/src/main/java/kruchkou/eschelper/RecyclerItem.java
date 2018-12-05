package kruchkou.eschelper;

public class RecyclerItem {

    private int number;
    private int act_id;
    private String model;
    private String note;

    public RecyclerItem(int act_id, int number, String model, String note) {
        this.number = number;
        this.act_id = act_id;
        this.model = model;
        this.note = note;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAct_id() {
        return act_id;
    }

    public void setAct_id(int act_id) {
        this.act_id = act_id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}