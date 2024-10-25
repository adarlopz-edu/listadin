package adaptador;

import static global.info.lista;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.listadin.R;
import java.util.ArrayList;
import java.util.List;
import pojo.equipo;

public class adaptadoreliminar extends RecyclerView.Adapter<adaptadoreliminar.activity> {
    public Context context;

    @NonNull
    @Override
    public activity onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = View.inflate(context,R.layout.viewholder2, null);
        activity obj = new activity(v);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull activity miniactivity, int i) {
        final int pos = i;
        miniactivity.nombre.setText(lista.get(i).getTeam());
        miniactivity.check.setChecked(lista.get(i).isChecked());
        miniactivity.check.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Guardar el estado del checkbox en el ArrayList
            lista.get(pos).setChecked(isChecked);
        });
    }

    @Override

    public int getItemCount() {
        return lista.size();
    }

    public static void eliminarSeleccionados() {
        List<equipo> itemsParaEliminar = new ArrayList<>();
        for (equipo item : lista) {
            if (item.isChecked()) {
                itemsParaEliminar.add(item);
            }
        }
        //notifyDataSetChanged();
        lista.removeAll(itemsParaEliminar);
    }

    public class activity extends RecyclerView.ViewHolder {
        TextView nombre;
        CheckBox check;

        public activity(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.theview2);
            check = itemView.findViewById(R.id.check);
        }
    }

}
