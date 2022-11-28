package Exceptions;

import java.io.IOException;

public class IncorrectValue extends IOException
{
    public IncorrectValue() {
        super("Возможно, некорректно введены данные.");
    }
}
