
package hospitalautomation.Infrastructure;

import java.util.List;

public interface IEntityRepository<T extends IEntity>  {
    List<T> getList();
    T get();
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}
