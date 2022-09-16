package com.rocketteam.d3vs.db;

import android.database.Cursor;
import androidx.collection.LongSparseArray;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.rocketteam.d3vs.db.converter.converters;
import com.rocketteam.d3vs.db.entities.Aluno;
import com.rocketteam.d3vs.db.entities.Interesses;
import com.rocketteam.d3vs.db.entities.Usuario;
import com.rocketteam.d3vs.db.entities.UsuarioAluno;
import java.lang.Class;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlunoDAO_Impl extends AlunoDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Aluno> __insertionAdapterOfAluno;

  private final EntityInsertionAdapter<Usuario> __insertionAdapterOfUsuario;

  private final converters __converters = new converters();

  private final EntityInsertionAdapter<Interesses> __insertionAdapterOfInteresses;

  private final EntityDeletionOrUpdateAdapter<Aluno> __deletionAdapterOfAluno;

  private final EntityDeletionOrUpdateAdapter<Aluno> __updateAdapterOfAluno;

  private final EntityDeletionOrUpdateAdapter<Usuario> __updateAdapterOfUsuario;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public AlunoDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAluno = new EntityInsertionAdapter<Aluno>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `t_aluno` (`t_user_id_user`) VALUES (nullif(?, 0))";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Aluno value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__insertionAdapterOfUsuario = new EntityInsertionAdapter<Usuario>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `t_user` (`id_user`,`discriminacao`,`nm_usuario`,`dt_nascimento`,`nr_cpf`,`ds_email`,`ds_senha`,`googleauth`) VALUES (nullif(?, 0),?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Usuario value) {
        stmt.bindLong(1, value.getId());
        if (value.getDiscriminacao() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDiscriminacao());
        }
        if (value.getNome() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNome());
        }
        final String _tmp = __converters.LocalDateToString(value.getDtNasc());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getCpf() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCpf());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmail());
        }
        if (value.getSenha() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSenha());
        }
        if (value.getGoogleAuth() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGoogleAuth());
        }
      }
    };
    this.__insertionAdapterOfInteresses = new EntityInsertionAdapter<Interesses>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `t_interesses` (`id_interesses`,`t_aluno_t_user_id_user`,`ds_interesse`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Interesses value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdAluno());
        if (value.getInteresse() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getInteresse());
        }
      }
    };
    this.__deletionAdapterOfAluno = new EntityDeletionOrUpdateAdapter<Aluno>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `t_aluno` WHERE `t_user_id_user` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Aluno value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfAluno = new EntityDeletionOrUpdateAdapter<Aluno>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `t_aluno` SET `t_user_id_user` = ? WHERE `t_user_id_user` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Aluno value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getId());
      }
    };
    this.__updateAdapterOfUsuario = new EntityDeletionOrUpdateAdapter<Usuario>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `t_user` SET `id_user` = ?,`discriminacao` = ?,`nm_usuario` = ?,`dt_nascimento` = ?,`nr_cpf` = ?,`ds_email` = ?,`ds_senha` = ?,`googleauth` = ? WHERE `id_user` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Usuario value) {
        stmt.bindLong(1, value.getId());
        if (value.getDiscriminacao() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDiscriminacao());
        }
        if (value.getNome() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getNome());
        }
        final String _tmp = __converters.LocalDateToString(value.getDtNasc());
        if (_tmp == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, _tmp);
        }
        if (value.getCpf() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getCpf());
        }
        if (value.getEmail() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getEmail());
        }
        if (value.getSenha() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindString(7, value.getSenha());
        }
        if (value.getGoogleAuth() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getGoogleAuth());
        }
        stmt.bindLong(9, value.getId());
      }
    };
    this.__preparedStmtOfDelete = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "delete from t_aluno where t_user_id_user = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(final Aluno Aluno) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfAluno.insertAndReturnId(Aluno);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public long insert(final Usuario Usuario) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfUsuario.insertAndReturnId(Usuario);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Long[] insert(final Interesses[] Interesses) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      Long[] _result = __insertionAdapterOfInteresses.insertAndReturnIdsArrayBox(Interesses);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Aluno Aluno) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAluno.handle(Aluno);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Aluno Aluno) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAluno.handle(Aluno);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateUsuario(final Usuario Usuario) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUsuario.handle(Usuario);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insert(final Aluno Aluno, final Usuario Usuario, final Interesses[] Interesses) {
    __db.beginTransaction();
    try {
      AlunoDAO_Impl.super.insert(Aluno, Usuario, Interesses);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final int Id) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDelete.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, Id);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDelete.release(_stmt);
    }
  }

  @Override
  public UsuarioAluno findById(final int Id) {
    final String _sql = "select * from t_user, t_aluno where id_user = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, Id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "t_user_id_user");
      final LongSparseArray<Usuario> _collectionUsuario = new LongSparseArray<Usuario>();
      final LongSparseArray<ArrayList<Interesses>> _collectionInteresses = new LongSparseArray<ArrayList<Interesses>>();
      while (_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
        _collectionUsuario.put(_tmpKey, null);
        final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
        ArrayList<Interesses> _tmpInteressesCollection = _collectionInteresses.get(_tmpKey_1);
        if (_tmpInteressesCollection == null) {
          _tmpInteressesCollection = new ArrayList<Interesses>();
          _collectionInteresses.put(_tmpKey_1, _tmpInteressesCollection);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_collectionUsuario);
      __fetchRelationshiptInteressesAscomRocketteamD3vsDbEntitiesInteresses(_collectionInteresses);
      final UsuarioAluno _result;
      if(_cursor.moveToFirst()) {
        final Aluno _tmpAluno;
        if (! (_cursor.isNull(_cursorIndexOfId))) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpAluno = new Aluno(_tmpId);
        }  else  {
          _tmpAluno = null;
        }
        Usuario _tmpUsuario = null;
        final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfId);
        _tmpUsuario = _collectionUsuario.get(_tmpKey_2);
        ArrayList<Interesses> _tmpInteressesCollection_1 = null;
        final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfId);
        _tmpInteressesCollection_1 = _collectionInteresses.get(_tmpKey_3);
        if (_tmpInteressesCollection_1 == null) {
          _tmpInteressesCollection_1 = new ArrayList<Interesses>();
        }
        _result = new UsuarioAluno(_tmpAluno,_tmpUsuario,_tmpInteressesCollection_1);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public UsuarioAluno findByEmail(final String Email) {
    final String _sql = "select * from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) where ds_email = ? and discriminacao = 'aluno'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (Email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Email);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "t_user_id_user");
      final LongSparseArray<Usuario> _collectionUsuario = new LongSparseArray<Usuario>();
      final LongSparseArray<ArrayList<Interesses>> _collectionInteresses = new LongSparseArray<ArrayList<Interesses>>();
      while (_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
        _collectionUsuario.put(_tmpKey, null);
        final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
        ArrayList<Interesses> _tmpInteressesCollection = _collectionInteresses.get(_tmpKey_1);
        if (_tmpInteressesCollection == null) {
          _tmpInteressesCollection = new ArrayList<Interesses>();
          _collectionInteresses.put(_tmpKey_1, _tmpInteressesCollection);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_collectionUsuario);
      __fetchRelationshiptInteressesAscomRocketteamD3vsDbEntitiesInteresses(_collectionInteresses);
      final UsuarioAluno _result;
      if(_cursor.moveToFirst()) {
        final Aluno _tmpAluno;
        if (! (_cursor.isNull(_cursorIndexOfId))) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpAluno = new Aluno(_tmpId);
        }  else  {
          _tmpAluno = null;
        }
        Usuario _tmpUsuario = null;
        final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfId);
        _tmpUsuario = _collectionUsuario.get(_tmpKey_2);
        ArrayList<Interesses> _tmpInteressesCollection_1 = null;
        final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfId);
        _tmpInteressesCollection_1 = _collectionInteresses.get(_tmpKey_3);
        if (_tmpInteressesCollection_1 == null) {
          _tmpInteressesCollection_1 = new ArrayList<Interesses>();
        }
        _result = new UsuarioAluno(_tmpAluno,_tmpUsuario,_tmpInteressesCollection_1);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<UsuarioAluno> listAll() {
    final String _sql = "select * from t_user, t_aluno";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "t_user_id_user");
      final LongSparseArray<Usuario> _collectionUsuario = new LongSparseArray<Usuario>();
      final LongSparseArray<ArrayList<Interesses>> _collectionInteresses = new LongSparseArray<ArrayList<Interesses>>();
      while (_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
        _collectionUsuario.put(_tmpKey, null);
        final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
        ArrayList<Interesses> _tmpInteressesCollection = _collectionInteresses.get(_tmpKey_1);
        if (_tmpInteressesCollection == null) {
          _tmpInteressesCollection = new ArrayList<Interesses>();
          _collectionInteresses.put(_tmpKey_1, _tmpInteressesCollection);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_collectionUsuario);
      __fetchRelationshiptInteressesAscomRocketteamD3vsDbEntitiesInteresses(_collectionInteresses);
      final List<UsuarioAluno> _result = new ArrayList<UsuarioAluno>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UsuarioAluno _item;
        final Aluno _tmpAluno;
        if (! (_cursor.isNull(_cursorIndexOfId))) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          _tmpAluno = new Aluno(_tmpId);
        }  else  {
          _tmpAluno = null;
        }
        Usuario _tmpUsuario = null;
        final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfId);
        _tmpUsuario = _collectionUsuario.get(_tmpKey_2);
        ArrayList<Interesses> _tmpInteressesCollection_1 = null;
        final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfId);
        _tmpInteressesCollection_1 = _collectionInteresses.get(_tmpKey_3);
        if (_tmpInteressesCollection_1 == null) {
          _tmpInteressesCollection_1 = new ArrayList<Interesses>();
        }
        _item = new UsuarioAluno(_tmpAluno,_tmpUsuario,_tmpInteressesCollection_1);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean autenticar(final String Email, final String Senha) {
    final String _sql = "select count(*) from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) where ds_email = ? and ds_senha = ? and discriminacao = 'aluno'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (Email == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Email);
    }
    _argIndex = 2;
    if (Senha == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, Senha);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public boolean autenticar(final String GoogleAuth) {
    final String _sql = "select count(*) from t_user u inner join t_aluno a on (a.t_user_id_user = u.id_user) where googleauth = ? and discriminacao = 'aluno'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (GoogleAuth == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, GoogleAuth);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final boolean _result;
      if(_cursor.moveToFirst()) {
        final int _tmp;
        _tmp = _cursor.getInt(0);
        _result = _tmp != 0;
      } else {
        _result = false;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }

  private void __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(
      final LongSparseArray<Usuario> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<Usuario> _tmpInnerMap = new LongSparseArray<Usuario>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), null);
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_tmpInnerMap);
          _map.putAll(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<Usuario>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_tmpInnerMap);
        _map.putAll(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id_user`,`discriminacao`,`nm_usuario`,`dt_nascimento`,`nr_cpf`,`ds_email`,`ds_senha`,`googleauth` FROM `t_user` WHERE `id_user` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "id_user");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfDiscriminacao = 1;
      final int _cursorIndexOfNome = 2;
      final int _cursorIndexOfDtNasc = 3;
      final int _cursorIndexOfCpf = 4;
      final int _cursorIndexOfEmail = 5;
      final int _cursorIndexOfSenha = 6;
      final int _cursorIndexOfGoogleAuth = 7;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        if (_map.containsKey(_tmpKey)) {
          final Usuario _item_1;
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpDiscriminacao;
          if (_cursor.isNull(_cursorIndexOfDiscriminacao)) {
            _tmpDiscriminacao = null;
          } else {
            _tmpDiscriminacao = _cursor.getString(_cursorIndexOfDiscriminacao);
          }
          final String _tmpNome;
          if (_cursor.isNull(_cursorIndexOfNome)) {
            _tmpNome = null;
          } else {
            _tmpNome = _cursor.getString(_cursorIndexOfNome);
          }
          final LocalDate _tmpDtNasc;
          final String _tmp;
          if (_cursor.isNull(_cursorIndexOfDtNasc)) {
            _tmp = null;
          } else {
            _tmp = _cursor.getString(_cursorIndexOfDtNasc);
          }
          _tmpDtNasc = __converters.StringToLocalDate(_tmp);
          final String _tmpCpf;
          if (_cursor.isNull(_cursorIndexOfCpf)) {
            _tmpCpf = null;
          } else {
            _tmpCpf = _cursor.getString(_cursorIndexOfCpf);
          }
          final String _tmpEmail;
          if (_cursor.isNull(_cursorIndexOfEmail)) {
            _tmpEmail = null;
          } else {
            _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
          }
          final String _tmpSenha;
          if (_cursor.isNull(_cursorIndexOfSenha)) {
            _tmpSenha = null;
          } else {
            _tmpSenha = _cursor.getString(_cursorIndexOfSenha);
          }
          final String _tmpGoogleAuth;
          if (_cursor.isNull(_cursorIndexOfGoogleAuth)) {
            _tmpGoogleAuth = null;
          } else {
            _tmpGoogleAuth = _cursor.getString(_cursorIndexOfGoogleAuth);
          }
          _item_1 = new Usuario(_tmpId,_tmpDiscriminacao,_tmpNome,_tmpDtNasc,_tmpCpf,_tmpEmail,_tmpSenha,_tmpGoogleAuth);
          _map.put(_tmpKey, _item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }

  private void __fetchRelationshiptInteressesAscomRocketteamD3vsDbEntitiesInteresses(
      final LongSparseArray<ArrayList<Interesses>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<Interesses>> _tmpInnerMap = new LongSparseArray<ArrayList<Interesses>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshiptInteressesAscomRocketteamD3vsDbEntitiesInteresses(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<Interesses>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshiptInteressesAscomRocketteamD3vsDbEntitiesInteresses(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id_interesses`,`t_aluno_t_user_id_user`,`ds_interesse` FROM `t_interesses` WHERE `t_aluno_t_user_id_user` IN (");
    final int _inputSize = _map.size();
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _stmt = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (int i = 0; i < _map.size(); i++) {
      long _item = _map.keyAt(i);
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    final Cursor _cursor = DBUtil.query(__db, _stmt, false, null);
    try {
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "t_aluno_t_user_id_user");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfIdAluno = 1;
      final int _cursorIndexOfInteresse = 2;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<Interesses> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final Interesses _item_1;
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final int _tmpIdAluno;
          _tmpIdAluno = _cursor.getInt(_cursorIndexOfIdAluno);
          final String _tmpInteresse;
          if (_cursor.isNull(_cursorIndexOfInteresse)) {
            _tmpInteresse = null;
          } else {
            _tmpInteresse = _cursor.getString(_cursorIndexOfInteresse);
          }
          _item_1 = new Interesses(_tmpId,_tmpIdAluno,_tmpInteresse);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
