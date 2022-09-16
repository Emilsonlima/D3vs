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
import com.rocketteam.d3vs.db.entities.Qualificacoes;
import com.rocketteam.d3vs.db.entities.Tutor;
import com.rocketteam.d3vs.db.entities.Usuario;
import com.rocketteam.d3vs.db.entities.UsuarioTutor;
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
public final class TutorDAO_Impl extends TutorDAO {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Tutor> __insertionAdapterOfTutor;

  private final EntityInsertionAdapter<Usuario> __insertionAdapterOfUsuario;

  private final converters __converters = new converters();

  private final EntityInsertionAdapter<Qualificacoes> __insertionAdapterOfQualificacoes;

  private final EntityDeletionOrUpdateAdapter<Tutor> __deletionAdapterOfTutor;

  private final EntityDeletionOrUpdateAdapter<Tutor> __updateAdapterOfTutor;

  private final EntityDeletionOrUpdateAdapter<Usuario> __updateAdapterOfUsuario;

  private final SharedSQLiteStatement __preparedStmtOfDelete;

  public TutorDAO_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTutor = new EntityInsertionAdapter<Tutor>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `t_prof` (`t_user_id_user`,`ds_prof`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tutor value) {
        stmt.bindLong(1, value.getId());
        if (value.getDescricao() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescricao());
        }
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
    this.__insertionAdapterOfQualificacoes = new EntityInsertionAdapter<Qualificacoes>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `t_qualificacoes` (`id_qualificacoes`,`t_prof_t_user_id_user`,`ds_linguagem`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Qualificacoes value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getIdTutor());
        if (value.getLinguagem() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getLinguagem());
        }
      }
    };
    this.__deletionAdapterOfTutor = new EntityDeletionOrUpdateAdapter<Tutor>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `t_prof` WHERE `t_user_id_user` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tutor value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfTutor = new EntityDeletionOrUpdateAdapter<Tutor>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `t_prof` SET `t_user_id_user` = ?,`ds_prof` = ? WHERE `t_user_id_user` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Tutor value) {
        stmt.bindLong(1, value.getId());
        if (value.getDescricao() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDescricao());
        }
        stmt.bindLong(3, value.getId());
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
        final String _query = "delete from t_prof where t_user_id_user = ?";
        return _query;
      }
    };
  }

  @Override
  public long insert(final Tutor Tutor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfTutor.insertAndReturnId(Tutor);
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
  public Long[] insert(final Qualificacoes[] Qualificacoes) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      Long[] _result = __insertionAdapterOfQualificacoes.insertAndReturnIdsArrayBox(Qualificacoes);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final Tutor Tutor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTutor.handle(Tutor);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final Tutor Tutor) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTutor.handle(Tutor);
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
  public void insert(final Tutor Tutor, final Usuario Usuario,
      final Qualificacoes[] Qualificacoes) {
    __db.beginTransaction();
    try {
      TutorDAO_Impl.super.insert(Tutor, Usuario, Qualificacoes);
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
  public UsuarioTutor findById(final int Id) {
    final String _sql = "select * from t_user, t_prof where id_user = ? and discriminacao = 'prof'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, Id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "t_user_id_user");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "ds_prof");
      final LongSparseArray<Usuario> _collectionUsuario = new LongSparseArray<Usuario>();
      final LongSparseArray<ArrayList<Qualificacoes>> _collectionQualificacoes = new LongSparseArray<ArrayList<Qualificacoes>>();
      while (_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
        _collectionUsuario.put(_tmpKey, null);
        final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
        ArrayList<Qualificacoes> _tmpQualificacoesCollection = _collectionQualificacoes.get(_tmpKey_1);
        if (_tmpQualificacoesCollection == null) {
          _tmpQualificacoesCollection = new ArrayList<Qualificacoes>();
          _collectionQualificacoes.put(_tmpKey_1, _tmpQualificacoesCollection);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_collectionUsuario);
      __fetchRelationshiptQualificacoesAscomRocketteamD3vsDbEntitiesQualificacoes(_collectionQualificacoes);
      final UsuarioTutor _result;
      if(_cursor.moveToFirst()) {
        final Tutor _tmpTutor;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfDescricao))) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpDescricao;
          if (_cursor.isNull(_cursorIndexOfDescricao)) {
            _tmpDescricao = null;
          } else {
            _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
          }
          _tmpTutor = new Tutor(_tmpId,_tmpDescricao);
        }  else  {
          _tmpTutor = null;
        }
        Usuario _tmpUsuario = null;
        final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfId);
        _tmpUsuario = _collectionUsuario.get(_tmpKey_2);
        ArrayList<Qualificacoes> _tmpQualificacoesCollection_1 = null;
        final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfId);
        _tmpQualificacoesCollection_1 = _collectionQualificacoes.get(_tmpKey_3);
        if (_tmpQualificacoesCollection_1 == null) {
          _tmpQualificacoesCollection_1 = new ArrayList<Qualificacoes>();
        }
        _result = new UsuarioTutor(_tmpTutor,_tmpUsuario,_tmpQualificacoesCollection_1);
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
  public UsuarioTutor findByEmail(final String Email) {
    final String _sql = "select * from t_user u inner join t_prof a on (a.t_user_id_user = u.id_user) where ds_email = ? and discriminacao = 'prof'";
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
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "ds_prof");
      final LongSparseArray<Usuario> _collectionUsuario = new LongSparseArray<Usuario>();
      final LongSparseArray<ArrayList<Qualificacoes>> _collectionQualificacoes = new LongSparseArray<ArrayList<Qualificacoes>>();
      while (_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
        _collectionUsuario.put(_tmpKey, null);
        final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
        ArrayList<Qualificacoes> _tmpQualificacoesCollection = _collectionQualificacoes.get(_tmpKey_1);
        if (_tmpQualificacoesCollection == null) {
          _tmpQualificacoesCollection = new ArrayList<Qualificacoes>();
          _collectionQualificacoes.put(_tmpKey_1, _tmpQualificacoesCollection);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_collectionUsuario);
      __fetchRelationshiptQualificacoesAscomRocketteamD3vsDbEntitiesQualificacoes(_collectionQualificacoes);
      final UsuarioTutor _result;
      if(_cursor.moveToFirst()) {
        final Tutor _tmpTutor;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfDescricao))) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpDescricao;
          if (_cursor.isNull(_cursorIndexOfDescricao)) {
            _tmpDescricao = null;
          } else {
            _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
          }
          _tmpTutor = new Tutor(_tmpId,_tmpDescricao);
        }  else  {
          _tmpTutor = null;
        }
        Usuario _tmpUsuario = null;
        final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfId);
        _tmpUsuario = _collectionUsuario.get(_tmpKey_2);
        ArrayList<Qualificacoes> _tmpQualificacoesCollection_1 = null;
        final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfId);
        _tmpQualificacoesCollection_1 = _collectionQualificacoes.get(_tmpKey_3);
        if (_tmpQualificacoesCollection_1 == null) {
          _tmpQualificacoesCollection_1 = new ArrayList<Qualificacoes>();
        }
        _result = new UsuarioTutor(_tmpTutor,_tmpUsuario,_tmpQualificacoesCollection_1);
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
  public List<UsuarioTutor> listAll() {
    final String _sql = "select * from t_user, t_prof where discriminacao = 'prof'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, true, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "t_user_id_user");
      final int _cursorIndexOfDescricao = CursorUtil.getColumnIndexOrThrow(_cursor, "ds_prof");
      final LongSparseArray<Usuario> _collectionUsuario = new LongSparseArray<Usuario>();
      final LongSparseArray<ArrayList<Qualificacoes>> _collectionQualificacoes = new LongSparseArray<ArrayList<Qualificacoes>>();
      while (_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_cursorIndexOfId);
        _collectionUsuario.put(_tmpKey, null);
        final long _tmpKey_1 = _cursor.getLong(_cursorIndexOfId);
        ArrayList<Qualificacoes> _tmpQualificacoesCollection = _collectionQualificacoes.get(_tmpKey_1);
        if (_tmpQualificacoesCollection == null) {
          _tmpQualificacoesCollection = new ArrayList<Qualificacoes>();
          _collectionQualificacoes.put(_tmpKey_1, _tmpQualificacoesCollection);
        }
      }
      _cursor.moveToPosition(-1);
      __fetchRelationshiptUserAscomRocketteamD3vsDbEntitiesUsuario(_collectionUsuario);
      __fetchRelationshiptQualificacoesAscomRocketteamD3vsDbEntitiesQualificacoes(_collectionQualificacoes);
      final List<UsuarioTutor> _result = new ArrayList<UsuarioTutor>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final UsuarioTutor _item;
        final Tutor _tmpTutor;
        if (! (_cursor.isNull(_cursorIndexOfId) && _cursor.isNull(_cursorIndexOfDescricao))) {
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final String _tmpDescricao;
          if (_cursor.isNull(_cursorIndexOfDescricao)) {
            _tmpDescricao = null;
          } else {
            _tmpDescricao = _cursor.getString(_cursorIndexOfDescricao);
          }
          _tmpTutor = new Tutor(_tmpId,_tmpDescricao);
        }  else  {
          _tmpTutor = null;
        }
        Usuario _tmpUsuario = null;
        final long _tmpKey_2 = _cursor.getLong(_cursorIndexOfId);
        _tmpUsuario = _collectionUsuario.get(_tmpKey_2);
        ArrayList<Qualificacoes> _tmpQualificacoesCollection_1 = null;
        final long _tmpKey_3 = _cursor.getLong(_cursorIndexOfId);
        _tmpQualificacoesCollection_1 = _collectionQualificacoes.get(_tmpKey_3);
        if (_tmpQualificacoesCollection_1 == null) {
          _tmpQualificacoesCollection_1 = new ArrayList<Qualificacoes>();
        }
        _item = new UsuarioTutor(_tmpTutor,_tmpUsuario,_tmpQualificacoesCollection_1);
        _result.add(_item);
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

  private void __fetchRelationshiptQualificacoesAscomRocketteamD3vsDbEntitiesQualificacoes(
      final LongSparseArray<ArrayList<Qualificacoes>> _map) {
    if (_map.isEmpty()) {
      return;
    }
    // check if the size is too big, if so divide;
    if(_map.size() > RoomDatabase.MAX_BIND_PARAMETER_CNT) {
      LongSparseArray<ArrayList<Qualificacoes>> _tmpInnerMap = new LongSparseArray<ArrayList<Qualificacoes>>(androidx.room.RoomDatabase.MAX_BIND_PARAMETER_CNT);
      int _tmpIndex = 0;
      int _mapIndex = 0;
      final int _limit = _map.size();
      while(_mapIndex < _limit) {
        _tmpInnerMap.put(_map.keyAt(_mapIndex), _map.valueAt(_mapIndex));
        _mapIndex++;
        _tmpIndex++;
        if(_tmpIndex == RoomDatabase.MAX_BIND_PARAMETER_CNT) {
          __fetchRelationshiptQualificacoesAscomRocketteamD3vsDbEntitiesQualificacoes(_tmpInnerMap);
          _tmpInnerMap = new LongSparseArray<ArrayList<Qualificacoes>>(RoomDatabase.MAX_BIND_PARAMETER_CNT);
          _tmpIndex = 0;
        }
      }
      if(_tmpIndex > 0) {
        __fetchRelationshiptQualificacoesAscomRocketteamD3vsDbEntitiesQualificacoes(_tmpInnerMap);
      }
      return;
    }
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT `id_qualificacoes`,`t_prof_t_user_id_user`,`ds_linguagem` FROM `t_qualificacoes` WHERE `t_prof_t_user_id_user` IN (");
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
      final int _itemKeyIndex = CursorUtil.getColumnIndex(_cursor, "t_prof_t_user_id_user");
      if (_itemKeyIndex == -1) {
        return;
      }
      final int _cursorIndexOfId = 0;
      final int _cursorIndexOfIdTutor = 1;
      final int _cursorIndexOfLinguagem = 2;
      while(_cursor.moveToNext()) {
        final long _tmpKey = _cursor.getLong(_itemKeyIndex);
        ArrayList<Qualificacoes> _tmpRelation = _map.get(_tmpKey);
        if (_tmpRelation != null) {
          final Qualificacoes _item_1;
          final int _tmpId;
          _tmpId = _cursor.getInt(_cursorIndexOfId);
          final int _tmpIdTutor;
          _tmpIdTutor = _cursor.getInt(_cursorIndexOfIdTutor);
          final String _tmpLinguagem;
          if (_cursor.isNull(_cursorIndexOfLinguagem)) {
            _tmpLinguagem = null;
          } else {
            _tmpLinguagem = _cursor.getString(_cursorIndexOfLinguagem);
          }
          _item_1 = new Qualificacoes(_tmpId,_tmpIdTutor,_tmpLinguagem);
          _tmpRelation.add(_item_1);
        }
      }
    } finally {
      _cursor.close();
    }
  }
}
