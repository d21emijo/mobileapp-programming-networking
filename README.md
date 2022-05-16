
# Rapport


## skapa recycler view utifrån json






### recyclerview

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



### json

I koden skapar vi en gson från våran Json data och en lista av berg.

```
        Gson gson = new Gson();
        Type type = new TypeToken<List<Mountain>>() {}.getType();
        List<Mountain> listOfMountains = gson.fromJson(json, type);
```
vi hämtar listan från url och sparar denna som nedan i JSON_URL

```
    private final String JSON_URL = "https://mobprog.webug.se/json-api?login=brom";
```

därefter skapar vi en ny Json av denna url så vi kan använda den i java.

```
 new JsonTask(this).execute(JSON_URL);

```






### skicka vidare mha adapter


```
private RecyclerView recyclerView; //skapa variabel
private RecyclerViewAdapter recyclerViewAdapter; //skapa variabel
```



### skaffa utrymme

viewholder räknar ut hur mycket plats som kommer att gå åt och sparar plats för listan av berg som ska visas.


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



















```
 private List<Mountain> items = new ArrayList<>();
```

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



