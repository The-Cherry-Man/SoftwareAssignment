public interface UserComputeAPI1<T> {

    //Takes in user number Data
    ConfigKey UserNumberInput(T N);

    //Chooses the users Delimeter.
    ConfigKey DelimeterOuput(Delimeter D);

    //Sets the destination of the data results
    ConfigKey DestinationOutput(Destination D);

   Result Compute(ConfigKeyCollection C);

   //Delimeter Choices
    char D1 = ';';
    char D2 = '|';
    char D3 = '/';

}
