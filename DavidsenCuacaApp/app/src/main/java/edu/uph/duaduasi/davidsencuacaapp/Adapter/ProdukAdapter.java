package edu.uph.duaduasi.davidsencuacaapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

import edu.uph.duaduasi.davidsencuacaapp.Model.Produk;
import edu.uph.duaduasi.davidsencuacaapp.R;

public class ProdukAdapter extends ArrayAdapter<Produk> {

    private ArrayList<Produk> produkArrayList;
    Context context;

    public ProdukAdapter(ArrayList<Produk> produkArrayList, Context context) {
        super(context, R.layout.list_layout,produkArrayList);
        this.produkArrayList = produkArrayList;
        this.context = context;
    }

    private static class MyViewFolder{
        ImageView gambarProduk;
        TextView namaProduk;
        TextView hargaProduk;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Produk produk = getItem(position);
        final View result;

        MyViewFolder myViewFolder;

        if(convertView==null) {
            myViewFolder = new MyViewFolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_layout, parent, false);

            myViewFolder.gambarProduk = (ImageView) convertView.findViewById(R.id.gambarProduk);
            myViewFolder.namaProduk= (TextView) convertView.findViewById(R.id.namaProduk);
            myViewFolder.hargaProduk= (TextView) convertView.findViewById(R.id.hargaProduk);

            convertView.setTag(myViewFolder);
        }
        else {
            myViewFolder = (MyViewFolder) convertView.getTag();
        }
        result = convertView;
        myViewFolder.gambarProduk.setImageResource(produk.getGambarProduk());
        myViewFolder.hargaProduk.setText("IDR. "+ produk.getHargaProduk());
        myViewFolder.namaProduk.setText(produk.getNamaProduk());
        return result;
    }
}
