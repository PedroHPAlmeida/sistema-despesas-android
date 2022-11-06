package br.com.fatec.despesas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.fatec.despesas.R;
import br.com.fatec.despesas.dto.DespesaDto;

public class DespesaAdapter extends RecyclerView.Adapter<DespesaAdapter.DespesaViewHolder> {

    List<DespesaDto> despesas;

    public DespesaAdapter(List<DespesaDto> despesas) {
        this.despesas = despesas;
    }

    @NonNull
    @Override
    public DespesaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.despesa_adapter, parent, false);
        return new DespesaViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull DespesaViewHolder holder, int position) {
        holder.textViewDespesa.setText(despesas.get(position).getDespesa());
        holder.textViewValor.setText("R$ " + despesas.get(position).getValor());
    }

    @Override
    public int getItemCount() {
        return despesas.size();
    }

    protected class DespesaViewHolder extends RecyclerView.ViewHolder{
        private TextView textViewDespesa;
        private TextView textViewValor;

        public DespesaViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewDespesa = itemView.findViewById(R.id.textViewDespesa);
            textViewValor = itemView.findViewById(R.id.textViewValor);
        }
    }
}
