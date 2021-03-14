package com.util;

import java.util.Date;
import java.util.*;

import com.model.Flat;
import com.model.Transport;
import com.model.Furnish;

/**
 * Operates the com.commands.
 */

public class CollectionManager{
    public TreeMap<Integer, Flat> treeMap;
    public FileManager fileManager;
    public int id;
    public Date date = new Date();
    public CollectionManager(FileManager fileManager) {
        this.fileManager = fileManager;
         loadCollection();
    }

    public void setTreeMap(TreeMap<Integer, Flat> treeMap) {
        this.treeMap = treeMap;
    }

    public int getId() {
        return id;
    }

    public void setFileManager(FileManager fileManager) {
        this.fileManager = fileManager;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TreeMap<Integer, Flat> getTreeMap() {
        return treeMap;
    }


    public void insertNull(Flat flat, int key){
        treeMap.put(key, flat);
    }
    public void removeKey(int key){
        treeMap.remove(key);
    }
    public void show(){
        String str;
        for (Integer i : treeMap.keySet()){
            System.out.println("key = " + i+ " " +treeMap.get(i).toString());
        }

    }
    public String info(){
        return treeMap.getClass() + " " + date + " " +  treeMap.size();
    }
    public void clear(){
        treeMap.clear();
    }
    public void removeAllByFurnish(Furnish furnish){
        List<Integer> key = new ArrayList();
        for (Integer i : treeMap.keySet()){
            if(treeMap.get(i).getFurnish()==furnish){
                key.add(i);
            }
        }
        for (int i : key){
            treeMap.remove(i);
        }
    }
    public boolean removeAnyByFurnish(Furnish furnish){
        for (Integer i : treeMap.keySet()){
            if(treeMap.get(i).getFurnish()==furnish){
                treeMap.remove(i);
                return  true;
            }
        }
        return false;
    }
    public int countByTransport(Transport transport){
        int l = 0;
        for (Integer i : treeMap.keySet()){
            if(treeMap.get(i).getTransport()==transport){
                l++;
            }
        }
        return l;
    }
    public void removeGreater(Flat flat){
        for (Integer i : treeMap.keySet()){
            if(flat.compareTo(treeMap.get(i))<0){
                treeMap.remove(i);
                break;
            }
        }
    }
    public void update(Flat flat){
        for (Integer i : treeMap.keySet()){
            if (treeMap.get(i).getId() == flat.getId()){
                treeMap.remove(i);
                treeMap.put(i, flat);
            }
        }
    }
    public boolean checkId(int id){
        for (Integer i : treeMap.keySet()){
            if (treeMap.get(i).getId() == id){
                return true;
            }
        }
        return false;
    }
    public boolean replaceIfLowe(int key, Flat flat){
        if (flat.compareTo(treeMap.get(key))>0){
            flat.setId(treeMap.get(key).getId());
            treeMap.remove(key);
            treeMap.put(key, flat);
            return true;
        }
        return false;
    }
    public boolean checkKey(int key){
        return treeMap.containsKey(key);
    }
    public boolean checkFlat(Flat flat){
        return treeMap.containsValue(flat);
    }
    public boolean checkEmpty(){
        return treeMap.size()>0;
    }
    public int collectionSize(){
        return treeMap.size();
    }
    public Integer generateNextId(){
        if(treeMap.size() == 0) {
            id = 1;
            return 1;
        }
        id++;
        return id;
    }
    public void saveCollection(){
        fileManager.saveCollectionToFile();
    }
    private void loadCollection(){
        treeMap = fileManager.parseCollectionFromFile();
    }
}