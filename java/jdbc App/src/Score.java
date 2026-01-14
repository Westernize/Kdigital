import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

class ScoreFrame extends JFrame implements ActionListener, MouseListener {

    ScoreDao scoreDao;
    ScoreDto scoreDto;

    JLabel jlName, jlkor, jlEng, jlMat;
    JTextField jtName, jtKor, jtEng, jtMat;
    JButton jbAdd, jbDel, jbChange;
    JTable table;
    Vector data, col;

    ScoreFrame() {
        setLayout(null);
        scoreDao = new ScoreDao();

        add(jlName = new JLabel("이름", JLabel.CENTER));
        jlName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jlName.setBorder(BorderFactory.createBevelBorder(0));
        jlName.setBounds(10, 10, 120, 50);
        add(jtName = new JTextField());
        jtName.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jtName.setHorizontalAlignment(JTextField.CENTER);
        jtName.setBounds(140, 10, 120, 50);

        add(jlkor = new JLabel("국어 점수", JLabel.CENTER));
        jlkor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jlkor.setBorder(BorderFactory.createBevelBorder(0));
        jlkor.setBounds(10, 70, 120, 50);
        add(jtKor = new JTextField());
        jtKor.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jtKor.setHorizontalAlignment(JTextField.CENTER);
        jtKor.setBounds(140, 70, 120, 50);

        add(jlEng = new JLabel("영어 점수", JLabel.CENTER));
        jlEng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jlEng.setBorder(BorderFactory.createBevelBorder(0));
        jlEng.setBounds(10, 130, 120, 50);
        add(jtEng = new JTextField());
        jtEng.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jtEng.setHorizontalAlignment(JTextField.CENTER);
        jtEng.setBounds(140, 130, 120, 50);

        add(jlMat = new JLabel("수학 점수", JLabel.CENTER));
        jlMat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jlMat.setBorder(BorderFactory.createBevelBorder(0));
        jlMat.setBounds(10, 190, 120, 50);
        add(jtMat = new JTextField());
        jtMat.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jtMat.setHorizontalAlignment(JTextField.CENTER);
        jtMat.setBounds(140, 190, 120, 50);

        add(jbAdd = new JButton("추가"));
        jbAdd.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jbAdd.setBounds(270, 10, 120, 50);
        jbAdd.addActionListener(this);

        add(jbDel = new JButton("삭제"));
        jbDel.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jbDel.setBounds(270, 70, 120, 50);
        jbDel.addActionListener(this);

        add(jbChange = new JButton("수정"));
        jbChange.setFont(new Font("맑은 고딕", Font.BOLD, 20));
        jbChange.setBounds(270, 130, 120, 50);
        jbChange.addActionListener(this);

        col = new Vector();
        col.add("이름");
        col.add("국어점수");
        col.add("영어점수");
        col.add("수학점수");
        col.add("총점");
        col.add("평균");

        DefaultTableModel model = new DefaultTableModel(scoreDao.getScore(), col) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(model);
        table.addMouseListener(this);

        JScrollPane scroll = new JScrollPane(table);
        jTableSet();
        add(scroll);
        scroll.setBounds(415, 10, 770, 250);

        setResizable(false);
        setSize(1200, 300);
        setTitle("성적 관리 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String ButtonFlag = e.getActionCommand();

        if (ButtonFlag.equals("추가")) {
            try {
                contentSet();
                int result = scoreDao.insertScore(scoreDto);
                if (result == 1) {
                    JOptionPane.showMessageDialog(this, "추가 되었습니다.");
                    jTableRefresh();
                    contentClear();
                } else {
                    JOptionPane.showMessageDialog(this, "실패 하였습니다.");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "값을 입력해주세요!");
            }
        } else if (ButtonFlag.equals("삭제")) {
            try {
                contentSet();
                int result = scoreDao.deleteScore(scoreDto);
                if (result == 1) {
                    JOptionPane.showMessageDialog(this, "삭제 되었습니다.");
                    jTableRefresh();
                    contentClear();
                } else {
                    JOptionPane.showMessageDialog(this, "실패 하였습니다.");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "값을 입력해주세요!");
            }
        } else if (ButtonFlag.equals("수정")) {
            try {
                contentSet();
                int result = scoreDao.updateScore(scoreDto);
                if (result == 1) {
                    JOptionPane.showMessageDialog(this, "수정 되었습니다.");
                    jTableRefresh();
                    contentClear();
                } else {
                    JOptionPane.showMessageDialog(this, "실패 하였습니다.");
                }
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(this, "값을 입력해주세요!");
            }
        }
    }

    private void jTableSet() {
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
        celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(celAlignCenter);
        }
    }

    private void jTableRefresh() {
        DefaultTableModel model = new DefaultTableModel(scoreDao.getScore(), col) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setModel(model);
        jTableSet();
    }

    private void contentSet() {
        scoreDto = new ScoreDto();
        String name = jtName.getText().trim();
        int kor = Integer.parseInt(jtKor.getText().trim());
        int eng = Integer.parseInt(jtEng.getText().trim());
        int mat = Integer.parseInt(jtMat.getText().trim());
        int tot = kor + eng + mat;
        int ave = tot / 3;

        scoreDto.setName(name);
        scoreDto.setKor(kor);
        scoreDto.setEng(eng);
        scoreDto.setMat(mat);
        scoreDto.setTot(tot);
        scoreDto.setAve(ave);
    }

    private void contentClear() {
        jtName.setText("");
        jtKor.setText("");
        jtEng.setText("");
        jtMat.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int rowIndex = table.getSelectedRow();
        jtName.setText(table.getValueAt(rowIndex, 0) + "");
        jtKor.setText(table.getValueAt(rowIndex, 1) + "");
        jtEng.setText(table.getValueAt(rowIndex, 2) + "");
        jtMat.setText(table.getValueAt(rowIndex, 3) + "");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // 선택시 동작 필요 없으면 비워둡니다.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // 선택 해제시 동작 필요 없으면 비워둡니다.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // 마우스 진입 시 동작 필요 없으면 비워둡니다.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // 마우스 이탈 시 동작 필요 없으면 비워둡니다.
    }
}
public class Score {
    public static void main(String[] args) {
        new ScoreFrame();
    }
}

