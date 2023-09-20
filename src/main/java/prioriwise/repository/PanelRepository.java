package prioriwise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import prioriwise.model.Panel;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long> {

    Panel findByCode(String code);
}
