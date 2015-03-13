package ch.heigvd.res.lab01.impl.explorers;

import ch.heigvd.res.lab01.interfaces.IFileExplorer;
import ch.heigvd.res.lab01.interfaces.IFileVisitor;
import java.io.File;

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
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isDirectory()) {
                    explore(listFiles[i], vistor);
                    vistor.visit(listFiles[i]);
                }
            }
            for (int i = 0; i < listFiles.length; i++) {
                if (listFiles[i].isFile()) {
                    vistor.visit(listFiles[i]);
                }
            }
        }

    }
}
