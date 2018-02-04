/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integrity_validation_javafx.client;

public class ValidatorKeyGenerator
{


    String key = "";

    public String getKey(String textLine)
    {
     
       MD5  m=new MD5();
       textLine =m.getHash(textLine);
       
       int x = textLine.length();

        char charRandom[] = textLine.toCharArray();
        int keynum = x % 7;
        if (keynum == 0)
        {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 1;
                if (i < textLine.length())
                {
                    key = key + charRandom[i];
                    charRandom=rotate(charRandom);

                }
                else
                {
                    i = 0;
                }

            }
        }
         if (keynum == 1)
         {
            for (int i = 0; key.length() < 7; i++)
            {
                i = i + 2;
                if (i < textLine.length())
                	{
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                }
                 else
                	{
                    i = 0;
                }

            }
        }
         if (keynum == 2) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 3;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (keynum == 3) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 4;
                if (i < textLine.length()) {

                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (keynum == 4) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 5;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (keynum == 5) {
            for (int i = 0; key.length() < 7; i++) {
                i = i + 6;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }
         if (keynum == 6) {
            for (int i = 0; key.length() < 7; i++) {
                i = i +7;
                if (i < textLine.length()) {
                    key = key + charRandom[i];
                     charRandom=rotate(charRandom);
                } else {
                    i = 0;
                }

            }
        }

          key=key.toUpperCase();
        return (key);

    }

public char[] rotate(char Array[])
{
       char temp;

            temp=Array[Array.length-1];
            Array[Array.length-1]=Array[0];
                for(int i=0;i<Array.length-1;i++)
                {
                 Array[i]=Array[i+1];


             }
           Array[Array.length-2]=temp;
    return Array;
}

}
