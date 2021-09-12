public class a5_11_SingleQuestion extends a5_10_Question{
   private char answer;

    public a5_11_SingleQuestion() {

    }

    public a5_11_SingleQuestion(String text, String[] options, char answer) {
        super(text, options);
        this.answer = answer;
    }

    @Override
    public boolean check(char[] answers) {
        if(answers==null || answers.length>1)
            return false;
        return this.answer == Character.toUpperCase(answers[0]);
    }
}
