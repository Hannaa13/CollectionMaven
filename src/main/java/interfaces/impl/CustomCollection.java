package interfaces.impl;

import interfaces.CustomInterfaceCollect;

public class CustomCollection implements CustomInterfaceCollect {
    public String[] array;
    public int count = 0;

    public CustomCollection() {
        this.array = new String[3];
    }

    @Override
    public boolean add(String str) {

        if (count < array.length) {
            array[count] = str;
            count++;
        } else {
            array = copy();
            array[count] = str;
            count++;
        }
        return true;
    }

    private String[] copy() {
        String[] arrNew = new String[count + count * 2 / 3];
        for (int i = 0; i < array.length; i++) {
            arrNew[i] = array[i];
        }
        return arrNew;
    }

    @Override
    public boolean addAll(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            add(strArr[i]);
        }
        return true;
    }

    @Override
    public boolean addAll(CustomCollection strColl) {
        trim();
        String[] arrayNew = new String[array.length + strColl.size()];

        for (int i = 0; i < count; i++) {
            arrayNew[i] = array[i];
        }
        for (int i = 0; i < strColl.size(); i++) {
            arrayNew[count] = strColl.getByIndex(i);
            count++;
        }
        array = arrayNew;
        return true;
    }

    @Override
    public boolean delete(int index) {
        if (index > size()) return false;
        else {
            count--;
            for (int i = index; i < count; i++) {
                array[i] = array[i + 1];
            }
        }
        return true;
    }

    @Override
    public boolean delete(String str) {
        if (!contains(str))  return false;
        else {
            delete(find(str));
        }
        return true;
    }


    @Override
    public String getByIndex(int index) {
        if (index >= count)  return null;
        else
            return  array[index];
    }


    @Override
    public boolean contains(String str) {
        for (int i = 0; i < count; i++) {
            if (str == (array[i])) {
                return true;
            }
        }
        return false;
    }



    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean trim() {
        if (count==array.length) return false;
        String[] arrayNew = new String[count];
        for (int i = 0; i < count; i++) {
            {
                arrayNew[i] =array[i];
            }
        }
        array = arrayNew;
        return true;
    }

    @Override
    public boolean compare(CustomCollection coll) {

        if (count != coll.size()) return false;
        String[] arrayNew = new String[coll.size()];
        for (int i = 0; i < coll.size(); i++) {
            arrayNew[i] = coll.getByIndex(i);

            if (array[i] != arrayNew[i]) return false;
        }
        return true;
    }




    public int find(String str) {
        if (!contains(str))  return -1;
        int index= 0;
        for (int i = 0; i < count; i++) {
            if (str == (array[i])) {
                index = i;
            }
        }
        return index;
    }



}



