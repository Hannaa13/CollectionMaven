package interfaces;

import interfaces.impl.CustomCollection;

public interface CustomInterfaceCollect {
    boolean add(String str);

    boolean addAll(String[] strArr);

    boolean addAll(CustomCollection strColl);

    boolean delete (int index);

    boolean delete (String str);

    String getByIndex (int index);

    boolean contains(String str);


    int size();

    boolean trim();

    boolean compare(CustomCollection coll);


}


