package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame implements ActionListener {
    private Controller controller;
    private UndoManager undoManager = new UndoManager();
    private UndoListener undoListener = new UndoListener(undoManager);
    // это будет панель с двумя вкладками
    private JTabbedPane tabbedPane = new JTabbedPane();
    // это будет компонент для визуального редактирования html
    // Он будет размещен на первой вкладке
    private JTextPane htmlTextPane = new JTextPane();
    // компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();

    public Controller getController() {
        return controller;
    }

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }


    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }



    public void init() {
        initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }

    // инициализация граяическго интерфейса
    public void initGui() {
        initMenuBar();
        initEditor();
        pack();
    }

    // инициализация меню
    public void initMenuBar() {
        // создаю панель меню
        JMenuBar jMenuBar = new JMenuBar();
        MenuHelper.initFileMenu(this, jMenuBar);
        MenuHelper.initEditMenu(this, jMenuBar);
        MenuHelper.initStyleMenu(this, jMenuBar);
        MenuHelper.initAlignMenu(this, jMenuBar);
        MenuHelper.initColorMenu(this, jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
        getContentPane().add(jMenuBar, BorderLayout.NORTH);
    }

    // инициализация панели редактора
    public void initEditor() {
        htmlTextPane.setContentType("text/html");
        JScrollPane htmlTextPaneLocal = new JScrollPane(htmlTextPane);
        tabbedPane.add("HTML", htmlTextPaneLocal);
        JScrollPane plainTextPaneLocal = new JScrollPane(plainTextPane);
        tabbedPane.add("Текст", plainTextPaneLocal);
        tabbedPane.setPreferredSize(new Dimension(600, 500));
        TabbedPaneChangeListener tabbedPaneChangeListener = new TabbedPaneChangeListener(this);
        tabbedPane.addChangeListener(tabbedPaneChangeListener);
        getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }

    public boolean canUndo() {
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void exit() {
        controller.exit();
    }

    public void undo() {
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public void resetUndo() {
        undoManager.discardAllEdits();
    }

    public boolean isHtmlTabSelected() {
        if (tabbedPane.getSelectedIndex() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void selectHtmlTab() {
        tabbedPane.setSelectedIndex(0);
        resetUndo();
    }

    public void update() {
        HTMLDocument document = controller.getDocument();
        htmlTextPane.setDocument(document);
    }

    public void showAbout() {
        String message = "Here is information about app";
        JOptionPane optionPane = new JOptionPane();
        JOptionPane.showMessageDialog(optionPane, message, "About", JOptionPane.INFORMATION_MESSAGE);
    }


    public void selectedTabChanged() {
        if (tabbedPane.getSelectedIndex() == 0) {
            String text = plainTextPane.getText();
            controller.setPlainText(text);
        } else if (tabbedPane.getSelectedIndex() == 1) {
            String plainText = controller.getPlainText();
            plainTextPane.setText(plainText);
        }
        resetUndo();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String actionCommand = actionEvent.getActionCommand();
        if ("Новый".equals(actionCommand)) {
            controller.createNewDocument();
        } else if ("Открыть".equals(actionCommand)) {
            controller.openDocument();
        } else if ("Сохранить".equals(actionCommand)) {
            controller.saveDocument();
        } else if ("Сохранить как...".equals(actionCommand)) {
            controller.saveDocumentAs();
        } else if ("Выход".equals(actionCommand)) {
            controller.exit();
        } else if ("О программе".equals(actionCommand)) {
            showAbout();
        }
    }
}

//Реализуем метод actionPerformed(ActionEvent actionEvent) у представления,
// этот метод наследуется от интерфейса ActionListener и будет вызваться при выборе пунктов меню,
// у которых наше представление указано в виде слушателя событий.
//19.1. Получи из события команду с помощью метода getActionCommand(). Это будет обычная строка.
// По этой строке ты можешь понять какой пункт меню создал данное событие.
//19.2. Если это команда "Новый", вызови у контроллера метод createNewDocument(). В этом пункте и далее,
// если необходимого метода в контроллере еще нет - создай заглушки.
//19.3. Если это команда "Открыть", вызови метод openDocument().
//19.4. Если "Сохранить", то вызови saveDocument().
//19.5. Если "Сохранить как..." - saveDocumentAs().
//19.6. Если "Выход" - exit().
//19.7. Если "О программе", то вызови метод showAbout() у представления.
//Проверь, что заработали пункты меню Выход и О программе.
//
//
//Требования:
//1. Метод actionPerformed(ActionEvent actionEvent) должен получать из события команду с помощью метода getActionCommand().
//2. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Новый",
// метод должен вызывать у контроллера createNewDocument().
//3. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Открыть",
// метод должен вызывать у контроллера openDocument().
//4. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить",
// метод должен вызывать у контроллера saveDocument().
//5. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Сохранить как...",
// метод должен вызывать у контроллера saveDocumentAs().
//6. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "Выход",
// метод должен вызывать у контроллера exit().
//7. Если в метод actionPerformed(ActionEvent actionEvent) передано событие с командой "О программе",
// метод должен вызывать у представления showAbout().