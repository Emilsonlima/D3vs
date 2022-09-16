package com.rocketteam.d3vs.db;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class D3vsDataBase_Impl extends D3vsDataBase {
  private volatile TutorDAO _tutorDAO;

  private volatile AlunoDAO _alunoDAO;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(9) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_user` (`id_user` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `discriminacao` TEXT, `nm_usuario` TEXT NOT NULL, `dt_nascimento` TEXT, `nr_cpf` TEXT, `ds_email` TEXT NOT NULL, `ds_senha` TEXT NOT NULL, `googleauth` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_aluno` (`t_user_id_user` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_prof` (`t_user_id_user` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `ds_prof` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_interesses` (`id_interesses` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `t_aluno_t_user_id_user` INTEGER NOT NULL, `ds_interesse` TEXT NOT NULL, FOREIGN KEY(`t_aluno_t_user_id_user`) REFERENCES `t_user`(`id_user`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_qualificacoes` (`id_qualificacoes` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `t_prof_t_user_id_user` INTEGER NOT NULL, `ds_linguagem` TEXT NOT NULL)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `t_aula` (`id_aula` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `t_aluno_t_user_id_user` INTEGER NOT NULL, `t_prof_t_user_id_user` INTEGER NOT NULL, FOREIGN KEY(`t_aluno_t_user_id_user`) REFERENCES `t_user`(`id_user`) ON UPDATE NO ACTION ON DELETE NO ACTION , FOREIGN KEY(`t_prof_t_user_id_user`) REFERENCES `t_user`(`id_user`) ON UPDATE NO ACTION ON DELETE NO ACTION )");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5ab6f67e25ab8a6d487698e5e4b9fbf8')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `t_user`");
        _db.execSQL("DROP TABLE IF EXISTS `t_aluno`");
        _db.execSQL("DROP TABLE IF EXISTS `t_prof`");
        _db.execSQL("DROP TABLE IF EXISTS `t_interesses`");
        _db.execSQL("DROP TABLE IF EXISTS `t_qualificacoes`");
        _db.execSQL("DROP TABLE IF EXISTS `t_aula`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        _db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsTUser = new HashMap<String, TableInfo.Column>(8);
        _columnsTUser.put("id_user", new TableInfo.Column("id_user", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("discriminacao", new TableInfo.Column("discriminacao", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("nm_usuario", new TableInfo.Column("nm_usuario", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("dt_nascimento", new TableInfo.Column("dt_nascimento", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("nr_cpf", new TableInfo.Column("nr_cpf", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("ds_email", new TableInfo.Column("ds_email", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("ds_senha", new TableInfo.Column("ds_senha", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTUser.put("googleauth", new TableInfo.Column("googleauth", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTUser = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTUser = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTUser = new TableInfo("t_user", _columnsTUser, _foreignKeysTUser, _indicesTUser);
        final TableInfo _existingTUser = TableInfo.read(_db, "t_user");
        if (! _infoTUser.equals(_existingTUser)) {
          return new RoomOpenHelper.ValidationResult(false, "t_user(com.rocketteam.d3vs.db.entities.Usuario).\n"
                  + " Expected:\n" + _infoTUser + "\n"
                  + " Found:\n" + _existingTUser);
        }
        final HashMap<String, TableInfo.Column> _columnsTAluno = new HashMap<String, TableInfo.Column>(1);
        _columnsTAluno.put("t_user_id_user", new TableInfo.Column("t_user_id_user", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTAluno = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTAluno = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTAluno = new TableInfo("t_aluno", _columnsTAluno, _foreignKeysTAluno, _indicesTAluno);
        final TableInfo _existingTAluno = TableInfo.read(_db, "t_aluno");
        if (! _infoTAluno.equals(_existingTAluno)) {
          return new RoomOpenHelper.ValidationResult(false, "t_aluno(com.rocketteam.d3vs.db.entities.Aluno).\n"
                  + " Expected:\n" + _infoTAluno + "\n"
                  + " Found:\n" + _existingTAluno);
        }
        final HashMap<String, TableInfo.Column> _columnsTProf = new HashMap<String, TableInfo.Column>(2);
        _columnsTProf.put("t_user_id_user", new TableInfo.Column("t_user_id_user", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTProf.put("ds_prof", new TableInfo.Column("ds_prof", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTProf = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTProf = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTProf = new TableInfo("t_prof", _columnsTProf, _foreignKeysTProf, _indicesTProf);
        final TableInfo _existingTProf = TableInfo.read(_db, "t_prof");
        if (! _infoTProf.equals(_existingTProf)) {
          return new RoomOpenHelper.ValidationResult(false, "t_prof(com.rocketteam.d3vs.db.entities.Tutor).\n"
                  + " Expected:\n" + _infoTProf + "\n"
                  + " Found:\n" + _existingTProf);
        }
        final HashMap<String, TableInfo.Column> _columnsTInteresses = new HashMap<String, TableInfo.Column>(3);
        _columnsTInteresses.put("id_interesses", new TableInfo.Column("id_interesses", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTInteresses.put("t_aluno_t_user_id_user", new TableInfo.Column("t_aluno_t_user_id_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTInteresses.put("ds_interesse", new TableInfo.Column("ds_interesse", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTInteresses = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysTInteresses.add(new TableInfo.ForeignKey("t_user", "NO ACTION", "NO ACTION",Arrays.asList("t_aluno_t_user_id_user"), Arrays.asList("id_user")));
        final HashSet<TableInfo.Index> _indicesTInteresses = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTInteresses = new TableInfo("t_interesses", _columnsTInteresses, _foreignKeysTInteresses, _indicesTInteresses);
        final TableInfo _existingTInteresses = TableInfo.read(_db, "t_interesses");
        if (! _infoTInteresses.equals(_existingTInteresses)) {
          return new RoomOpenHelper.ValidationResult(false, "t_interesses(com.rocketteam.d3vs.db.entities.Interesses).\n"
                  + " Expected:\n" + _infoTInteresses + "\n"
                  + " Found:\n" + _existingTInteresses);
        }
        final HashMap<String, TableInfo.Column> _columnsTQualificacoes = new HashMap<String, TableInfo.Column>(3);
        _columnsTQualificacoes.put("id_qualificacoes", new TableInfo.Column("id_qualificacoes", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTQualificacoes.put("t_prof_t_user_id_user", new TableInfo.Column("t_prof_t_user_id_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTQualificacoes.put("ds_linguagem", new TableInfo.Column("ds_linguagem", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTQualificacoes = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTQualificacoes = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTQualificacoes = new TableInfo("t_qualificacoes", _columnsTQualificacoes, _foreignKeysTQualificacoes, _indicesTQualificacoes);
        final TableInfo _existingTQualificacoes = TableInfo.read(_db, "t_qualificacoes");
        if (! _infoTQualificacoes.equals(_existingTQualificacoes)) {
          return new RoomOpenHelper.ValidationResult(false, "t_qualificacoes(com.rocketteam.d3vs.db.entities.Qualificacoes).\n"
                  + " Expected:\n" + _infoTQualificacoes + "\n"
                  + " Found:\n" + _existingTQualificacoes);
        }
        final HashMap<String, TableInfo.Column> _columnsTAula = new HashMap<String, TableInfo.Column>(3);
        _columnsTAula.put("id_aula", new TableInfo.Column("id_aula", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTAula.put("t_aluno_t_user_id_user", new TableInfo.Column("t_aluno_t_user_id_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTAula.put("t_prof_t_user_id_user", new TableInfo.Column("t_prof_t_user_id_user", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTAula = new HashSet<TableInfo.ForeignKey>(2);
        _foreignKeysTAula.add(new TableInfo.ForeignKey("t_user", "NO ACTION", "NO ACTION",Arrays.asList("t_aluno_t_user_id_user"), Arrays.asList("id_user")));
        _foreignKeysTAula.add(new TableInfo.ForeignKey("t_user", "NO ACTION", "NO ACTION",Arrays.asList("t_prof_t_user_id_user"), Arrays.asList("id_user")));
        final HashSet<TableInfo.Index> _indicesTAula = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoTAula = new TableInfo("t_aula", _columnsTAula, _foreignKeysTAula, _indicesTAula);
        final TableInfo _existingTAula = TableInfo.read(_db, "t_aula");
        if (! _infoTAula.equals(_existingTAula)) {
          return new RoomOpenHelper.ValidationResult(false, "t_aula(com.rocketteam.d3vs.db.entities.Aula).\n"
                  + " Expected:\n" + _infoTAula + "\n"
                  + " Found:\n" + _existingTAula);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5ab6f67e25ab8a6d487698e5e4b9fbf8", "2e9cbdc2442fe0031fa6db9b00495408");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "t_user","t_aluno","t_prof","t_interesses","t_qualificacoes","t_aula");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `t_user`");
      _db.execSQL("DELETE FROM `t_aluno`");
      _db.execSQL("DELETE FROM `t_prof`");
      _db.execSQL("DELETE FROM `t_interesses`");
      _db.execSQL("DELETE FROM `t_qualificacoes`");
      _db.execSQL("DELETE FROM `t_aula`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(TutorDAO.class, TutorDAO_Impl.getRequiredConverters());
    _typeConvertersMap.put(AlunoDAO.class, AlunoDAO_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public TutorDAO TutorDAO() {
    if (_tutorDAO != null) {
      return _tutorDAO;
    } else {
      synchronized(this) {
        if(_tutorDAO == null) {
          _tutorDAO = new TutorDAO_Impl(this);
        }
        return _tutorDAO;
      }
    }
  }

  @Override
  public AlunoDAO AlunoDAO() {
    if (_alunoDAO != null) {
      return _alunoDAO;
    } else {
      synchronized(this) {
        if(_alunoDAO == null) {
          _alunoDAO = new AlunoDAO_Impl(this);
        }
        return _alunoDAO;
      }
    }
  }
}
