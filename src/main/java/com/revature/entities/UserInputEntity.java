package com.revature.entities;

import com.revature.enums.ActionEnum;
import com.revature.enums.ControllerEnum;

public class UserInputEntity {
    private ActionEnum actionEnum;
    private ControllerEnum controllerEnum;
    private String userInputString;

    public UserInputEntity(){
        this.actionEnum = ActionEnum.NONE;
        this.controllerEnum = ControllerEnum.MAIN_MENU;
    }

    public String getUserInputString() {
        return userInputString;
    }

    public void setUserInputString(String userInputString) {
        this.userInputString = userInputString;
    }

    public ControllerEnum getControllerEnum() {
        return controllerEnum;
    }

    public void setControllerEnum(ControllerEnum controllerEnum) {
        this.controllerEnum = controllerEnum;
    }

    public ActionEnum getActionEnum() {
        return actionEnum;
    }

    public void setActionEnum(ActionEnum actionEnum) {
        this.actionEnum = actionEnum;
    }
}
