public interface API_2 {

    //Takes in user's input
   List Read(UserNumber N);

   //Writes to user's destination
   Response Write(UserNumber N, DelimeterOutput D, ConfigKey C);
}
