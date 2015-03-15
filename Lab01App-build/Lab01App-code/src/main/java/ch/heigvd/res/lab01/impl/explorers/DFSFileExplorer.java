package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;
import java.util.ArrayList;

/**
 * This implementation of the IFileExplorer interface performs a depth-first
 * exploration of the file system and invokes the visitor for every encountered
 * node (file and directory). When the explorer reaches a directory, it visits
 * all files in the directory and then moves into the subdirectories.
 *
 * @author Olivier Liechti
 */
public class DFSFileExplorer implements IFileExplorer {

    @Override
    public void explore(File rootDirectory, IFileVisitor vistor) {
        //throw new UnsupportedOperationException("The student has not implemented this method yet.");
        File[] listFiles = rootDirectory.listFiles();
        vistor.visit(rootDirectory);
        
        if (listFiles != null) {
        //we are a directory
            for (int i = 0; i < listFiles.length; i++) {
                explore(listFiles[i], vistor);
            }
        }
        
        /* ArrayList<String> a = new ArrayList<String>();
        //fill the arrayList with all the name of files
        for (int i = 0; i < listFiles.length; i++) {
            a.add(listFiles[i].getName());
        }
        a.sort(null);
        // Filenames are now ordered in a
        File[] orderedListFile = new File[listFiles.length];
        int j; 
        int n = 0;
        for (int i = 0; i < listFiles.length; i++) {
            while (n < listFiles.length) {
                j = 0;
                //search the ordered file
                while (!(listFiles[j].getName().equals(a.get(i)))) {
                    j++;
                    if (j == listFiles.length){
                        System.out.println("fucked");
                    }
                }
                //File in correct order is found, push it in the orderedListFile and remove its name from a
                orderedListFile[i] = listFiles[j];
                n++;
            }
        }
        if (listFiles != null) {
            for (int i = 0; i < orderedListFile.length; i++) {
                if (orderedListFile[i].isDirectory()) {
                    explore(orderedListFile[i], vistor);
                    vistor.visit(orderedListFile[i]);
                }
            }
            for (int i = 0; i < orderedListFile.length; i++) {
                if (orderedListFile[i].isFile()) {
                    vistor.visit(orderedListFile[i]);
                }
            }
        }*/
        /*if (listFiles != null) {
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    vistor.visit(listFiles[i]);
                }
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    explore(listFiles[i], vistor);
                    vistor.visit(listFiles[i]);
                }
            }

        }*/
    }

}
