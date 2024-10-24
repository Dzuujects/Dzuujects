package F28PB_CW;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/** Main class for the Word Index program */
public class WordIndex {

	static final File textFilesFolder = new File("TextFiles");
	static final FileFilter commandFileFilter = (File file) -> file.getParent() == null;
	static final FilenameFilter txtFilenameFilter = (File dir, String filename) -> filename.endsWith(".txt");

	public static void main(String[] argv) {
		
		
		if (argv.length != 1) {
			System.err.println("Usage: WordIndex commands.txt");
			System.exit(1);
		}
		try {
			File commandFile = new File(argv[0]);
			if (commandFile.getParent() != null) {
				System.err.println("Use a command file in current directory");
				System.exit(1);
			}

			// creating a command reader from a file
			WordTxtReader commandReader = new WordTxtReader(commandFile);

			// initialise map
			IWordMap wordPossMap = new ListWordMap();
			File[] listOfFiles = textFilesFolder.listFiles(txtFilenameFilter);
			
			System.out.println("Welcome to the Word Index");
			System.out.println();

			// reading the content of the command file
			while (commandReader.hasNextWord()) {
				// getting the next command
				String command = commandReader.nextWord().getWord();

				switch (command) {
				case "addall":
					assert (textFilesFolder.isDirectory());
					Arrays.sort(listOfFiles);
					for (File textFile : listOfFiles) {
						WordTxtReader wordReader = new WordTxtReader(textFile);

						while (wordReader.hasNextWord()) {
							WordPosition wordPos = wordReader.nextWord();
							
							wordPossMap.addPosition(wordPos.getWord(),wordPos);
						}
					}// adding word to the map from all files
					System.out.println(wordPossMap.numberOfEntries() + " entries have been added from " + listOfFiles.length + " files.");
					System.out.println("--------------------------------------------------------------------------------------------------");
					break;
				case "add":
					File textFile = new File(textFilesFolder, commandReader.nextWord().getWord() + ".txt");
					WordTxtReader wordReader = new WordTxtReader(textFile);
					int entryCount = 0;
					while (wordReader.hasNextWord()) {
						WordPosition word = wordReader.nextWord();
						wordPossMap.addPosition(word.getWord(), word);
						
						entryCount++;
					}// adding word to the map from a specific file
					System.out.println("Add Command - ");
					System.out.println(entryCount + " entries have been added from file " + textFile);
					System.out.println("--------------------------------------------------------------------------------------------------");
					break;
				case "search":
					int numberOfFiles = Integer.parseInt(commandReader.nextWord().getWord());
					String word = commandReader.nextWord().getWord();
					LinkedList<String> uniqueFiles = new LinkedList<>();
					
					// search for all word entry in map
					try {
						Iterator<IPosition> poss = wordPossMap.positions(word);
						int i = 0;
						while (poss.hasNext()) {
							IPosition position = poss.next();
							if (!uniqueFiles.contains((position).getFileName())) {
								uniqueFiles.add((position).getFileName());
							}
							i++;
						}
						System.out.println("Search Command - ");
						System.out.println("found " + i +" occurrences of \"" + word + "\" in " + uniqueFiles.size() + " files.");
					} catch (WordException e) {
						System.err.println("not found");
					}
					System.out.println();
					
					//search for word entry in each file
					int[] uniqueFilesFreq = new int[uniqueFiles.size()];
					String[] uniqueFilesName = new String[uniqueFiles.size()];
					
					try {
						//adds to arrays
						for (int i = 0; i < uniqueFiles.size(); i++) {
							Iterator<IPosition> pos = wordPossMap.positions(word);
							
							while (pos.hasNext()) {
									if (pos.next().getFileName().equalsIgnoreCase(uniqueFiles.get(i))) {
										uniqueFilesFreq[i]++;
										uniqueFilesName[i] = uniqueFiles.get(i);
									}
							}
						}
						//sorts arrays from highest to lowest frequency
						for (int i = 0; i < uniqueFilesFreq.length; i++) {
							for (int j = i+1; j < uniqueFilesFreq.length; j++ ) {
								if (uniqueFilesFreq[i] < uniqueFilesFreq[j]) {
									int swapFreq = uniqueFilesFreq[i];
									String swapName = uniqueFilesName[i];
									uniqueFilesFreq[i] = uniqueFilesFreq[j];
									uniqueFilesName[i] = uniqueFilesName[j];
									uniqueFilesFreq[j] = swapFreq;
									uniqueFilesName[j] = swapName;
								}
							}
						}
						//creates string for file to show which lines the word occurs
						String[] lines = new String[numberOfFiles];
						for (int i = 0; i < numberOfFiles; i++) {
							Iterator<IPosition> pos = wordPossMap.positions(word);
							String lineToString = "";
							while (pos.hasNext()) {
								IPosition check = pos.next();
								if (check.getFileName().equalsIgnoreCase(uniqueFilesName[i])) {
									lineToString = lineToString + check.getLineNumber() + ", ";
								}
								lines[i] = lineToString;
							}
						}
						//prints individual file occurrence
						for(int i = 0; i < numberOfFiles; i++) {
							System.out.println("found " + uniqueFilesFreq[i] +" occurrences of \"" + word + "\" in " + uniqueFilesName[i]);
							System.out.println("Lines: (" + lines[i] + ")" + '\n');
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					
					System.out.println("--------------------------------------------------------------------------------------------------");
					break;
				case "remove":
					// remove word-positions
					 String filenameToRemove = commandReader.nextWord().getWord();
					    File textFileToRemove = new File(textFilesFolder, filenameToRemove + ".txt");

					    // Get the number of entries before removal
					    int entriesBeforeRemoval = wordPossMap.numberOfEntries();

					    WordTxtReader removeWordReader = new WordTxtReader(textFileToRemove);

					    while (removeWordReader.hasNextWord()) {
					        WordPosition wordRemove = removeWordReader.nextWord();
					        // remove word from the map
					        try {
								wordPossMap.removePosition(wordRemove.getWord(), wordRemove);
							} catch (WordException e) {
								// catch any exception
								System.out.println("Not found");
							}
					    }

					    // Calculate the number of entries removed
					    int entriesRemoved = entriesBeforeRemoval - wordPossMap.numberOfEntries();
					    System.out.println("Remove Command - ");
					    if (entriesRemoved > 0) {
					        System.out.println(entriesRemoved + " entries have been removed from file " + textFileToRemove);
					    } else {
					        System.out.println("No entries found for file " + textFileToRemove);
					    }
					    System.out.println("--------------------------------------------------------------------------------------------------");
					break;
				case "overview":
					// print overview
					System.out.println("Overview Command - ");
					System.out.println("Number of files: " + listOfFiles.length);
					System.out.println("Number of words: " + wordPossMap.wordCounter());
					System.out.println("Number of entries: " + wordPossMap.numberOfEntries());
					System.out.println("--------------------------------------------------------------------------------------------------");
					break;
				default:
					break;
				}
			}
		} catch (IOException e) { // catch exceptions caused by file input/output errors
			System.err.println("Check your file name");
			System.exit(1);
		}
	}
}
