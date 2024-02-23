public interface UserComputeAPI1<T> {

    //Takes in user number Data
    ConfigKey userNumberInput(T N);

    //Chooses the users Delimeter.
    ConfigKey delimeterOuput(Delimeter D);

    //Sets the destination of the data results
    ConfigKey destinationOutput(Destination D);

   Result compute(ConfigKeyCollection C);

   //Delimeter Choices
    char D1 = ';';
    char D2 = '|';
    char D3 = '/';

}
