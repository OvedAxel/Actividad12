import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class AddressBook {
    private HashMap<String,string> contacts = new HashMaps<>();
    private String file = "C:\\Users\\ozuniga\\OneDrive\\Documents\\Java\\Contacts\\src\\ozuniga\\contacts.csv";
    public void load() throws IOException {
        String separator = FileSystems.getSystems.getDefault().getSeparator();
        String fileName = String.format("src%sozuniga%scontacts.csv", separator, separator, separator, separator);
        Path path = Paths.get(fileName);
        ArrayList<String> lines = new ArrayList<>();
        if(!Files.exists(path)){
            File file = new File(String.valueOf(path));
            file.createNewFile();
        }
        lines = (ArrayList<String>) Files.readAllLines(path);
        for (var contact : lines){
            var infoContact = contact.split(",");
            contacts.put(infoContact[0].trim(),infoContact[1],trim());

        }
    }
    public void save() throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String fileName = String.format("src%sozuniga%scontacts.csv", separator, separator, separator, separator);
        Path path = Paths.get(fileName);
        ArrayList<String> saveContacts = new ArrayList<>();
        for (var contact : contacts.entrySet()){
            saveContacts.add(contact.getKey()+", "+ contact.getValue());
        }

        Files.write(path,saveContacts);
    }
    public void list() throws IOException {
        try{
            load();
            FileReader showContacts = new FileReader(file);
            BufferedReader buffer = new BufferedReader(showContacts);
            if (Contacts.isEmpty()){
                System.out.println("Uhmm, it seems that there are no contacts. Try adding some!");
            }else{
                for (var contact : contacts.entrySet()){
                    System.out.println(String.format("Numero: %s, nombre: %s", contact.getKey(),contact.getValue()));
                }
            }

            buffer.close();
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("There is an error");
        }
    }
    public void create(String name, String lastname, String phone) throws IOException {
        if (contacts.containsKey(phone)){
            System.out.println("This contact already exists");
        }else {
            contacts.put(phone.trim(),nametrim()+ lastname.trim());
            save(); load();
            System.out.println("Contact succesfully added   ");
        }
    }

    public void delete(String phone) throws IOException {
        if (contacts.containsKey(phone)){
            System.out.println("This contact does not exist");
        }else {
            var p = contacts.remove(phone);
            save(); load();
            System.out.println("Contact deleted");
        }
    }


}
