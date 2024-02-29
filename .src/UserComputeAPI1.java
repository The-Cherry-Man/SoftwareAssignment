public interface UserComputeAPI1 {

    //Takes in user number Data
    ConfigKey userNumberInput(UserNumber n);

    //Chooses the users Delimeter.
    ConfigKey delimeterOuput(Delimeter d);

    //Sets the destination of the data results
    ConfigKey destinationOutput(Destination d);

   Result compute(ConfigKeyCollection c);

   //Delimeter Choices
    char d1 = ';';
    char d2 = '|';
    char d3 = '/';

}
