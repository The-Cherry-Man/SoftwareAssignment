public interface DataStorageComputeAPI2 {

    //Takes in user's input
   List read(UserNumber n);

   //Writes to user's destination
   Response write(UserNumber n, DelimeterOutput d, ConfigKey c);
}
