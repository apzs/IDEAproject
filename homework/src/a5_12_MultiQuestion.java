public class a5_12_MultiQuestion extends a5_10_Question{
    private char[] answer;   //答案

    public a5_12_MultiQuestion() {
    }

    public a5_12_MultiQuestion(String text, String[] options, char[] answer) {
        super(text, options);
        this.answer = answer;
    }

    @Override
    public boolean check(char[] answers) {
        String answers2 = new String(answers);
        answers2.trim().toUpperCase();
        String answer2 = new String(answer);
            if(answers2.length()==answer2.length()){
                for(int i=0 ; i< answers2.length() ; i++){
                   if (!answer2.contains("" +answers2.charAt(i)))
                       return false;
                }
                return true;
            }else return false;
    }
}
