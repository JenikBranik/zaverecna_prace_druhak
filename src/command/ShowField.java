package command;

import gameField.Field;

public class ShowField extends Command {

     Field f = new Field();

    public String execute() {
        //f.showField();
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
