package com.raychenon.licensedroid.license;

/**
 * Created by Raymond Chenon
 */
public abstract class OpenSourceLicense {

    public final String YEAR = "[yyyy]";
    public final String COPYRIGHT_HOLDER = "[owner]";

    abstract public String getName(); // include version

    abstract public String getNotice();

    public String getFullText() {
        return null; // longer than notice
    }

    public String getCopyrightFormat() {
        return null; //  Copyright [yyyy] [name of copyright owner]
    }

    public boolean hasCopyrightFormat(){
        return getCopyrightFormat() != null;
    }

    public String getNiceCopyright(final Integer year, final String holder){
        String copyright = getCopyrightFormat()
                .replace(YEAR,String.valueOf(year))
                .replace(COPYRIGHT_HOLDER,holder);
        return getName() + " - " + copyright;
    }

}
