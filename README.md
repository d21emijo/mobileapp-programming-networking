
# Rapport

todo
    
- [x]   Add a `RecyclerView` to your layout

i våran activity_main.xml så har vi skapat en recyclerview, denna xmlfil representerar alltså vad som ska visas i våran MainActivity. (context=".MainActivity")

```
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/recycler_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
```

- [x]   Add a `ArrayList<Mountain>` as a member variable in your activity






- [x]   Add a `RecyclerView.Adapter` as a member variable in your activity


```
private RecyclerViewAdapter recyclerViewAdapter; //skapa variabel
```



- [x]   Create a RecyclerView.Adapter and a RecyclerView.ViewHolder

```
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MountainViewHolder> {


    private List<Mountain> items = new ArrayList<>(); //hämta lista från mainactivity+fyller med samma items

    public void setItems(List<Mountain> items) {
        this.items = items;
    }

    public RecyclerViewAdapter() {

    }

    @Override
    @NonNull
    public MountainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MountainViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.mountain,parent,false));
    }
```








- [x]   Use getJson() to download your json data by changing the JSON_URL and write code in onPostExecute().

I koden i figuren nedan skapar vi en gson från våran Json data 

```
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> listOfMountains = gson.fromJson(json, type);
```

- [x]   Use the FamousPeaksJSON URL

```
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
```



- [x]   Hint: Use `adapter.notifyDataSetChanged();` after updating the list to let the adapter know that it should update the contents of the RecyclerView

```
        recyclerViewAdapter.notifyDataSetChanged();     //uppdatera

```


- [x] Display the names of the mountains in the `RecyclerView` 


![image](https://user-images.githubusercontent.com/102797583/168656631-a3bbf233-0722-47af-a8d9-f279205e700d.png)

här hämtar vi vilken plats i Json berget är på och skriver ut vilket det är. ex på index plats 0 är k2

```
    @Override
    public void onBindViewHolder(MountainViewHolder holder, int position) {
        Mountain mountain = items.get(position);//hämta index position

        holder.title.setText(mountain.getName()); //skriva ut i title name för index
        //för att skapa mer gör ny textview och använd settext som ovan.

    }
```



