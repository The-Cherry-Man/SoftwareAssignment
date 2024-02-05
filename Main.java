public interface API_1 {

    //Takes in user number Data
    ConfigKey UserNumberInput(UserNumber N);


    //Chooses the users Delimeter.
    ConfigKey DelimeterOuput(Delimeter D);


    //Sets the destination of the data results
    ConfigKey DestinationOutput(Destination D);

   Result Compute(ConfigKeyCollection C);

   //Delimeter Choices
    Char D1 = ';';
    Char D2 = '|';
    Char D3 = '/';

}
