public class a5_10_Question {
    private String text;         //题目
    private String[] options;    //选项

    public a5_10_Question() {
    }

    public a5_10_Question(String text, String[] options) {
        this.text = text;
        this.options = options;
    }

    public boolean check(char[] answers){
        return false;
    }

    public void print(){
        System.out.println(text);
        for (String option:options){
            System.out.println(option + " ");
        }
    }

}
