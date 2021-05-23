package filefinder;

import java.io.File;
import java.io.IOException;

public class ThreadedFileFinder implements Runnable {

    private File rootDir;
    private String fileName;

    public ThreadedFileFinder(String root, String goal) throws IOException {
        File rootDir = new File(root);
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory");
        }

        this.rootDir = rootDir;
        this.fileName = goal;
    }

    public ThreadedFileFinder(File file, String fileName){
        this.rootDir = file;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        File[] files = this.rootDir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    ThreadedFileFinder f = new ThreadedFileFinder(file, fileName);
                    f.run();
                }
            }
        }
    }
}
