package prioriwise.service;

import org.springframework.stereotype.Service;
import prioriwise.model.Panel;
import prioriwise.repository.PanelRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PanelService {

    private final PanelRepository panelRepository;

    public PanelService(PanelRepository panelRepository) {
        this.panelRepository = panelRepository;
    }

    public List<Panel> getAllPanels() {
        return panelRepository.findAll();
    }

    public Panel getPanelByCode(String code) {
        return panelRepository.findByCode(code);
    }

    public Panel getPanelByName(String title) {
        return panelRepository.findByName(title);
    }

    public Panel createPanel(Panel panel) {
        String uniqueCode = generateUniqueCode();

        while (panelRepository.findByCode(uniqueCode) != null) {
            uniqueCode = generateUniqueCode();
        }
        panel.setCode(uniqueCode);
        return panelRepository.save(panel);
    }

    public Panel updatePanel(Panel panel) {
        Panel oldPanel = panelRepository.findById(panel.getPanelId()).orElse(null);
        if (oldPanel != null) {
            oldPanel.setName(panel.getName());
            oldPanel.setShared(panel.isShared());
            oldPanel.setUsers(panel.getUsers());
            oldPanel.setTask(panel.getTask());
        }
        assert oldPanel != null;
        return panelRepository.save(oldPanel);
    }

    public void deletePanel(Long id) {
        panelRepository.deleteById(id);
    }

    private String generateUniqueCode() {
        return UUID.randomUUID().toString();
    }
}
