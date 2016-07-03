package com.mardomsara.social.ui.views;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 2/4/2016.
 */
public class TextParser {

    public TextParser(){

    }

    public static class Lexing {
        String text;
        int indexStep =0;
        int lastChunkIndex = 0;
        int txtLen =0;
        public List<LexEntry> chunks = new ArrayList<>();

        //For GC optimize
        char chr ;
//        String word;

        public Lexing(String txt) {
            text = txt;
            txtLen = txt.length();
        }

        public void parse(){
            for (; indexStep < txtLen ; ){
                chr = text.charAt(indexStep);
                switch(chr){
                    case '#':
                        if(isStartOfPrimeWord()){
                            foundHash();
                        }
                        break;

                    case '@':
//                        Log.d("parser", Character.toString(chr));
                        if(isStartOfPrimeWord()){
                            foundUseName();
                        }
                        break;
                }
                indexStep++;
            }
            addCurrentText();//last text
        }

        void foundHash(){
            addCurrentText();
            String word = takeWord();
            LexEntry obj = new LexEntry();
            obj.text = word;
            obj.type = TextType.Tag;

            chunks.add(obj);
        }
        void foundUseName(){
            addCurrentText();
            String word = takeWord();
//            Log.d("parser", word);
            LexEntry obj = new LexEntry();
            obj.text = word;
            obj.type = TextType.UserName;
            chunks.add(obj);

        }

        //its a prime word if: has previous space and hase at leat to char: " #a"
        boolean isStartOfPrimeWord(){
//            try {
                if(indexStep >= txtLen || ( (indexStep +1 < txtLen) && isSpace(text.charAt(indexStep +1))) ){
                    return false;
                }

                //just not 'Exeption' break next if
                if (indexStep == 0){
                    return true;
                }

                if ( (indexStep -1 > 0) && isSpace(text.charAt(indexStep -1))){
                    return true;
                }
//            }catch (Exception e){
//                AppUtil.log("isStartOfPrimeWord:"+ text+ "indexStep "+ indexStep +" txtLen " +txtLen);
//            }
            return false;
        }

        void addCurrentText(){
            StringBuffer str = new StringBuffer();
            while(lastChunkIndex < indexStep && lastChunkIndex < txtLen){
                str.append(text.charAt(lastChunkIndex));
                lastChunkIndex += 1;
            }

            LexEntry obj = new LexEntry();
            obj.text = str.toString();
            obj.type = TextType.SimpleText;

            chunks.add(obj);
        }

        //return and change state: '#tags' or '@kjkj'
        String takeWord(){
            StringBuffer str = new StringBuffer();
            while(indexStep < txtLen && !isSpace(text.charAt(indexStep))){
                str.append(text.charAt(indexStep));
                indexStep += 1;
            }
            lastChunkIndex = indexStep;
            return str.toString();
        }

        boolean isSpace(char chr){
            switch(chr){
                case ' ':
                case '\t':
                case '\n':
//                case '\v':
                case '\f':
                case '\r':
                    return true;
//                    break;
                default:
                    return false;
            }
        }

    }

    public static class LexEntry {
        public String text;
        public TextType type;

    }

    public static enum TextType{
        SimpleText,
        Tag,
        UserName
    }
}
