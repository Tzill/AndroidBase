package ru.geekbrains.socnet;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// построитель источника данных
public class DataSourceBuilder {
    private List<Soc> dataSource;   // строим этот источник данных
    private Resources resources;    // ресурсы приложения
    private InputStreamReader isr;
    private InputStream inputStream;
    private Context context;
    private static final String FILE_NAME = "likes.dat";
    private boolean[] likes;
    private String[] descriptions;

    public DataSourceBuilder(Resources resources, Context context) {
        descriptions = resources.getStringArray(R.array.descriptions);
        dataSource = new ArrayList<>(6);
        likes = new boolean[descriptions.length];
        this.context = context;
        this.resources = resources;

        readLikes(resources);
    }

    private void readLikes(Resources resources) {
        try {
            BufferedReader bReader = new BufferedReader(new InputStreamReader(context.openFileInput(FILE_NAME)));
            String line;
            for (int i = 0; i < descriptions.length; i++) {
                if ((line = bReader.readLine()) != null) {
                    if (line.equals("true")) likes[i] = true;
                    if (line.equals("false")) likes[i] = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private void readLikesFromResources(Resources resources) {
        try{
            inputStream = resources.getAssets().open("likes.dat");
            isr = new InputStreamReader(inputStream);
            Scanner sc = new Scanner(isr);
            String str;
            likes = new boolean[descriptions.length];

            for (int i = 0; i < descriptions.length; i++) {
                if (sc.hasNext()) {
                    str = sc.next();
                    if (str.equals("true")) likes[i] = true;
                    if (str.equals("false")) likes[i] = false;
                }
            }
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                isr.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void writeLikes(Resources resources) {
        try {
            String str = new String();
            String test = context.getFilesDir().toString()+"/"+FILE_NAME;
            File file = new File(test);
            boolean exists = file.exists();
            FileOutputStream fos = new FileOutputStream(file);
            //FileOutputStream fos = context.openFileOutput(test, Context.MODE_PRIVATE);
            for (int i = 0; i < descriptions.length; i++) {
                    if (likes[i] == true) str = "true" + "\n";
                    if (likes[i] == false) str = "false" + "\n";
                    fos.write(str.getBytes());
                }
        fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setLikes(int position, boolean isChecked){
        likes[position] = isChecked;
    }

    // строим данные
    public List<Soc> build() {
        // строки описаний из ресурсов
        //String[] descriptions = resources.getStringArray(R.array.descriptions);
        // изображения
        int[] pictures = getImageArray();
        // заполнение источника данных
        for (int i = 0; i < descriptions.length; i++) {
            dataSource.add(new Soc(descriptions[i], pictures[i], likes[i]));
        }
        return dataSource;
    }

    // Механизм вытаскивания идентификаторов картинок (к сожеланию просто массив не работает)
    // https://stackoverflow.com/questions/5347107/creating-integer-array-of-resource-ids
    private int[] getImageArray(){
        TypedArray pictures = resources.obtainTypedArray(R.array.pictures);
        int length = pictures.length();
        int[] answer = new int[length];
        for(int i = 0; i < length; i++){
            answer[i] = pictures.getResourceId(i, 0);
        }
        return answer;
    }
}
