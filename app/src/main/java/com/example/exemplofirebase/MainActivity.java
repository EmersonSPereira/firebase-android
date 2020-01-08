package com.example.exemplofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.exemplofirebase.com.exemple.exemplofirebase.modelo.Pessoa;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference usuarios = databaseReference.child("Pessoas");
    private FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        DatabaseReference usuarioPesquisa = usuarios.child("-Ly-oDdE5BNoS3nseZfg");
        Query usuarioPesquisa = usuarios.orderByChild("nome").startAt("Erinal").endAt("Erinal" + "\uf8ff");
        usuarioPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("Usuário Pesquisado ",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        /* Deslogar usuario */
//        firebaseAuth.signOut();


        /*Logar usuário*/

//        firebaseAuth.signInWithEmailAndPassword("emerson@gmail.com","123456")
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//            @Override
//            public void onComplete(@NonNull Task<AuthResult> task) {
//                if (task.isSuccessful()){
//                    Log.i("Usuário Logado", "Sim");
//                }else {
//                    Log.i("Usuário Logado", "Não");
//                }
//            }
//        });
        /**
         * verificando se usuário está logado
         */
//        verificarUsuarioLogado();


        /**
         * Criando um usuario no firebase
         */

//        cadastrarUsuário("emerson@gmail.com","123456");

//        usuarios.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange( DataSnapshot dataSnapshot) {
//                Log.i("FIREBASE", dataSnapshot.getValue().toString());
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        databaseReference.child("Pessoas").push()
//                .setValue(new Pessoa("Everton ",Integer.valueOf(24), Double.valueOf(1.78)));
//        databaseReference.child("Pessoas").push()
//                .setValue(new Pessoa("Emerson ",Integer.valueOf(26), Double.valueOf(1.78)));
//        databaseReference.child("Pessoas").push()
//                .setValue(new Pessoa("Cinthya ",Integer.valueOf(23), Double.valueOf(1.78)));
//        databaseReference.child("Pessoas").push()
//                .setValue(new Pessoa("Elton ",Integer.valueOf(18), Double.valueOf(1.78)));
//        databaseReference.child("Pessoas").push()
//                .setValue(new Pessoa("Erinaldo ",Integer.valueOf(45), Double.valueOf(1.78)));
//        databaseReference.child("Pessoas").push()
//                .setValue(new Pessoa("Jailma ",Integer.valueOf(45), Double.valueOf(1.78)));


    }

    private void verificarUsuarioLogado() {
        if (firebaseAuth.getCurrentUser() != null) {
            Log.i("Logado:", "Sim");
        } else {
            Log.i("Logado:", "Não");
        }
    }

    private void cadastrarUsuário(String usuario, String senha) {
        firebaseAuth.createUserWithEmailAndPassword(usuario, senha)
                .addOnCompleteListener(MainActivity.this
                        , new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Log.i("Usuario Criado", "usuario cadastrado com sucesso");
                                }
                            }
                        });
    }
}
