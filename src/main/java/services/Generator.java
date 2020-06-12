package api.services;

import api.date.DateTime;

/*
/* @author Augusto Marrengula */
public class Generator
{

    public String generateMpesaSaleKey()
    {
        int count = Integer.parseInt(new DateTime().getTime().split(":")[2].split(" ")[0]);

        String in = "IN";

        double randomNumber = Math.random();
        int randomNum = (int) (1 + randomNumber * (9 - 1));

        String text = count + "";

        switch (randomNum)
        {
            case 0:
                text += "DCX";
                break;
            case 1:
                text += "DXX";
                break;
            case 2:
                text += "VX";
                break;
            case 3:
                text += "X";
                break;
            case 4:
                text += "ICX";
                break;
            case 5:
                text += "DCX";
                break;
            case 6:
                text += "DK";
                break;
            case 7:
                text += "BRX";
                break;
            case 8:
                text += "D5X";
                break;
            case 9:
                text += "3X";
                break;

        }

        if (text.length() < 4)
        {
            if (text.length() == 1)
            {
                text += "123";
            }

            if (text.length() == 2)
            {
                text += "12";
            }

            if (text.length() == 3)
            {
                text += "1";
            }
        }

        return text + in + randomNum;      //return "1284O56";
    }

}
